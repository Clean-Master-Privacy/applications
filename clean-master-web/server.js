const express = require('express');
const bodyParser = require('body-parser');
const sqlite3 = require('sqlite3').verbose();
const cors = require('cors');

const app = express();
const PORT = 3000;

// Middleware
app.use(cors());
app.use(bodyParser.json());
app.use(express.static('public')); // Statik dosyalar için yol

// Veritabanı oluştur
const db = new sqlite3.Database(':memory:');

// Veritabanında tablo oluştur
db.serialize(() => {
    db.run("CREATE TABLE malicious_files (name TEXT)");
    
    // Örnek zararlı dosyaları ekle
    const stmt = db.prepare("INSERT INTO malicious_files VALUES (?)");
    stmt.run("virus.exe");
    stmt.run("malware.bat");
    stmt.run("trojan.dll");
    stmt.finalize();
});

// Dosyayı tarama
app.post('/scan', (req, res) => {
    const fileName = req.body.fileName;
    
    db.get("SELECT name FROM malicious_files WHERE name = ?", [fileName], (err, row) => {
        if (err) {
            return console.error(err.message);
        }
        res.json({
            isMalicious: !!row // satır varsa zararlıdır
        });
    });
});

// Sunucuyu başlat
app.listen(PORT, () => {
    console.log(`Sunucu ${PORT} portunda çalışıyor.`);
});
