const WebSocket = require('ws');
const { exec } = require('child_process');
const path = require('path');
const fs = require('fs');

const port = process.env.PORT || 8080;
const wss = new WebSocket.Server({ port: port });

wss.on('connection', ws => {
    ws.on('message', message => {
        if (message === 'clear') {
            ws.send("\x1b[H\x1b[2J");
        } 
        else if (message.startsWith('ls ')) {
            const dirPath = message.slice(3);
            const resolvedPath = path.resolve(dirPath);

            fs.readdir(resolvedPath, (err, files) => {
                if (err) {
                    ws.send(`Error: ${err.message}`);
                } else {
                    const filePaths = files.map(file => path.join(resolvedPath, file)).join('\n');
                    ws.send(filePaths);
                }
            });
        } 
        else {
            exec(message, (error, stdout, stderr) => {
                if (error) {
                    ws.send(`Error: ${stderr}`);
                } else {
                    ws.send(stdout);
                }
            });
        }
    });
});

console.log(`WebSocket server running on ws://localhost:${port}`);
