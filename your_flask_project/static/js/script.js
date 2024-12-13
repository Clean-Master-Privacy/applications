const form = document.getElementById('uploadForm');
const progressContainer = document.getElementById('progressContainer');
const progressBar = document.getElementById('progressBar');
const statusText = document.getElementById('status');
const filePathText = document.getElementById('filePath');

form.addEventListener('submit', function(e) {
    e.preventDefault();

    // Show the progress bar
    progressContainer.style.display = 'block';
    statusText.textContent = 'Uploading...';

    const formData = new FormData(form);
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/upload', true);

    xhr.upload.onprogress = function(event) {
        if (event.lengthComputable) {
            let percent = (event.loaded / event.total) * 100;
            progressBar.style.width = percent + '%';
        }
    };

    xhr.onload = function() {
        if (xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);
            statusText.textContent = response.message;
            if (response.status === 'success') {
                filePathText.textContent = 'File Path: ' + response.filepath;
            }
        } else {
            statusText.textContent = 'Error uploading file!';
        }
    };

    xhr.send(formData);
});
