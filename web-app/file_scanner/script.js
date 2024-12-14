document.getElementById('fileInput').addEventListener('change', function(event) {
    const fileList = document.getElementById('fileList');
    fileList.innerHTML = ''; // Mevcut dosyaları temizle

    Array.from(event.target.files).forEach(file => {
        const li = document.createElement('li');
        li.textContent = file.name; // Dosya adını ekle
        fileList.appendChild(li);
    });
});

document.getElementById('clearBtn').addEventListener('click', function() {
    const fileInput = document.getElementById('fileInput');
    fileInput.value = ''; // Dosya girişi temizle
    const fileList = document.getElementById('fileList');
    fileList.innerHTML = ''; // Listeyi temizle
});
