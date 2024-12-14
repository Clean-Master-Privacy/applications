// File List and Size Display
document.getElementById('fileInput').addEventListener('change', function (event) {
    const fileList = event.target.files;
    const output = document.getElementById('fileList');
    const preview = document.getElementById('preview');
    let totalSize = 0;
    output.innerHTML = '<h3>Dosyalar:</h3><ul>';
    preview.innerHTML = ''; // Clear previous previews

    for (let i = 0; i < fileList.length; i++) {
        const file = fileList[i];
        totalSize += file.size; // Calculate total size
        output.innerHTML += `<li>${file.name} (${(file.size / 1024).toFixed(2)} KB)</li>`;

        // Show image preview for images
        if (file.type.startsWith('image/')) {
            const img = document.createElement('img');
            img.src = URL.createObjectURL(file);
            preview.appendChild(img);
        }
    }

    output.innerHTML += `</ul><strong>Toplam Boyut: ${(totalSize / 1024).toFixed(2)} KB</strong>`; // Display total size
});

// Clear Files
document.getElementById('cleanBtn').addEventListener('click', function () {
    const fileInput = document.getElementById('fileInput');
    fileInput.value = '';
    document.getElementById('fileList').innerHTML = '';
    document.getElementById('preview').innerHTML = ''; // Clear preview
    alert("Temizleme işlemi başarılı!");
});
