document.getElementById("cleanCacheBtn").addEventListener("click", function() {
    document.getElementById("status").textContent = "Cleaning cache...";
    document.getElementById("progressContainer").style.display = "block";
    fetch("/clean_cache", { method: "POST" })
        .then(response => response.json())
        .then(data => {
            document.getElementById("status").textContent = data.message;
        });
});

document.getElementById("optimizePerformanceBtn").addEventListener("click", function() {
    document.getElementById("status").textContent = "Optimizing performance...";
    fetch("/optimize_performance", { method: "POST" })
        .then(response => response.json())
        .then(data => {
            document.getElementById("status").textContent = data.message;
        });
});

document.getElementById("saveDataBtn").addEventListener("click", function() {
    document.getElementById("status").textContent = "Optimizing data usage...";
    fetch("/save_data", { method: "POST" })
        .then(response => response.json())
        .then(data => {
            document.getElementById("status").textContent = data.message;
        });
});

document.getElementById("fileForm").addEventListener("submit", function(event) {
    event.preventDefault();
    let formData = new FormData();
    let fileInput = document.getElementById("fileInput");

    if (fileInput.files.length === 0) {
        alert("Please select a file!");
        return;
    }

    formData.append("file", fileInput.files[0]);

    fetch("/upload", {
        method: "POST",
        body: formData
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById("status").textContent = data.message;
        if (data.status === 'success') {
            // File upload success
            console.log("File uploaded: ", data.filepath);
        }
    });
});
