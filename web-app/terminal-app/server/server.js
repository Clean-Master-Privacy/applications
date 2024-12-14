const WebSocket = require('ws');
const { exec } = require('child_process');
const path = require('path');
const fs = require('fs');

// WebSocket server'ı başlat
const wss = new WebSocket.Server({ port: 8080 });

wss.on('connection', ws => {
    ws.on('message', message => {
        // Terminali temizleme komutu
        if (message === 'clear') {
            ws.send("\x1b[H\x1b[2J");  // ANSI escape kodlarıyla terminali temizle
        } 
        // ls komutu: Dizin içeriğini listeleme
        else if (message.startsWith('ls ')) {
            const dirPath = message.slice(3);  // 'ls ' komutunu çıkar
            const resolvedPath = path.resolve(dirPath);  // Mutlak yolu al

            fs.readdir(resolvedPath, (err, files) => {
                if (err) {
                    ws.send(`Error: ${err.message}`);  // Hata mesajını gönder
                } else {
                    const filePaths = files.map(file => path.join(resolvedPath, file)).join('\n');
                    ws.send(filePaths);  // Dosya yollarını frontend'e gönder
                }
            });
        } 
        // Diğer komutlar: Normal komutları çalıştır
        else {
            exec(message, (error, stdout, stderr) => {
                if (error) {
                    ws.send(`Error: ${stderr}`);
                } else {
                    ws.send(stdout);  // Çıktıyı frontend'e gönder
                }
            });
        }
    });
});

console.log('WebSocket server running on ws://localhost:8080');
