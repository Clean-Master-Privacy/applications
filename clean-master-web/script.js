// File List and Size Display
let totalSize = 0;

document.getElementById('fileInput').addEventListener('change', function (event) {
    const fileList = event.target.files;
    const output = document.getElementById('fileList');
    const preview = document.getElementById('preview');
    const summary = document.getElementById('summary');

    output.innerHTML = '<h3>Dosyalar:</h3><ul>';
    preview.innerHTML = ''; // Clear previous previews
    totalSize = 0; // Reset total size each time

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
    summary.innerHTML = ''; // Clear previous summary
});

// Clear Files
document.getElementById('cleanBtn').addEventListener('click', function () {
    const fileInput = document.getElementById('fileInput');
    const output = document.getElementById('fileList');
    const preview = document.getElementById('preview');
    const summary = document.getElementById('summary');

    fileInput.value = '';
    output.innerHTML = '';
    preview.innerHTML = ''; // Clear preview

    // Simulate cleaning action
    summary.innerHTML = `Temizleme işlemi başarılı! Toplam silinen boyut: ${(totalSize / 1024).toFixed(2)} KB.`;
    alert("Temizleme işlemi başarılı! Temizlenen boyut: " + (totalSize / 1024).toFixed(2) + " KB");
    
    // Optional: Clear browser history (only if permissions are granted, not demonstrated here)
    // This cannot be done via JavaScript in web context for security reasons.
});

// Function to handle privacy cleaning (limited and requires user permission)
function clearBrowserHistory() {
    // Browser history clearance can usually not be done due to security policies.
    alert("Tarayıcı geçmişi temizleme işlemi şu an desteklenmiyor.");
}
