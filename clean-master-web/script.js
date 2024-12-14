document.getElementById('scanBtn').addEventListener('click', function() {
    const fileList = document.getElementById('fileInput').files;
    const result = document.getElementById('result');
    
    result.innerHTML = '<h3>Taramanın Sonucu:</h3>';
    
    for (let i = 0; i < fileList.length; i++) {
        const file = fileList[i];
        
        // Dosya adı kontrolü
        fetch('/scan', {
            method: 'POST',
            body: JSON.stringify({ fileName: file.name }),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(data => {
            if (data.isMalicious) {
                result.innerHTML += `<p style="color: red;">Zararlı dosya bulundu: ${file.name}</p>`;
            } else {
                result.innerHTML += `<p style="color: green;">Güvenli dosya: ${file.name}</p>`;
            }
        });
    }
});
