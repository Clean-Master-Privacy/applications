const codeCanvas = document.getElementById('codeRain');
const ctxCode = codeCanvas.getContext('2d');
codeCanvas.width = window.innerWidth;
codeCanvas.height = window.innerHeight;

const codeSymbols = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
const fontSize = 14;
const columns = codeCanvas.width / fontSize;
const drops = Array.from({ length: columns }).fill(0);

function drawCodeRain() {
    ctxCode.fillStyle = 'rgba(0, 0, 0, 0.05)';
    ctxCode.fillRect(0, 0, codeCanvas.width, codeCanvas.height);

    ctxCode.fillStyle = '#00ff00';
    ctxCode.font = `${fontSize}px monospace`;

    drops.forEach((y, x) => {
        const text = codeSymbols[Math.floor(Math.random() * codeSymbols.length)];
        ctxCode.fillText(text, x * fontSize, y * fontSize);

        if (y * fontSize > codeCanvas.height && Math.random() > 0.95) {
            drops[x] = 0;
        }
        drops[x]++;
    });
}

setInterval(drawCodeRain, 50);
