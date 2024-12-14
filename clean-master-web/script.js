// Basit zararlı dosya listesi
const maliciousFiles = ['virus.exe', 'malware.bat', 'trojan.dll'];

// Basit heuristik kontrol
function heuristicCheck(file) {
    const heuristicIndicators = ['suspicious', 'malicious', 'dangerous'];
    
    // Örneğin, dosya adında bu kelimeleri barındırıyorsa zararlı olarak işaretle
    return heuristicIndicators.some(indicator => file.name.toLowerCase().includes(indicator));
}

document.getElementById('scanBtn').addEventListener('click', function() {
    const fileList = document.getElementById('fileInput').files;
    const result = document.getElementById('result');
    
    result.innerHTML = '<h3>Taramanın Sonucu:</h3>';
    
    for (let i = 0; i < fileList.length; i++) {
        const file = fileList[i];
        
        // İsim tabanlı kontrol
        if (maliciousFiles.includes(file.name)) {
            result.innerHTML += `<p style="color: red;">Zararlı dosya bulundu: ${file.name}</p>`;
        } 
        // Davranış tabanlı kontrol
        else if (heuristicCheck(file)) {
            result.innerHTML += `<p style="color: orange;">Şüpheli dosya bulundu: ${file.name}</p>`;
        } 
        else {
            result.innerHTML += `<p style="color: green;">Güvenli dosya: ${file.name}</p>`;
        }
    }
});
