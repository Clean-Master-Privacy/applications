// Cache Clean Functionality
document.getElementById("cleanCacheBtn").addEventListener("click", function() {
    document.getElementById("cleanCacheStatus").textContent = "Cleaning cache and cookies...";
    let progressBar = document.getElementById("cleanCacheBar");
    let width = 0;
    let interval = setInterval(function() {
        if (width >= 100) {
            clearInterval(interval);
            document.getElementById("cleanCacheStatus").textContent = "Cache and cookies cleaned successfully!";
        } else {
            width++;
            progressBar.style.width = width + "%";
        }
    }, 50); // Adjust the speed of progress bar
});

// Optimize Performance Functionality
document.getElementById("optimizePerformanceBtn").addEventListener("click", function() {
    document.getElementById("performanceStatus").textContent = "Optimizing system performance...";
    let progressBar = document.getElementById("performanceBar");
    let width = 0;
    let interval = setInterval(function() {
        if (width >= 100) {
            clearInterval(interval);
            document.getElementById("performanceStatus").textContent = "Performance optimized!";
        } else {
            width++;
            progressBar.style.width = width + "%";
        }
    }, 50); // Adjust the speed of progress bar
});

// Save Data Functionality
document.getElementById("saveDataBtn").addEventListener("click", function() {
    document.getElementById("dataStatus").textContent = "Optimizing data usage...";
    let progressBar = document.getElementById("dataBar");
    let width = 0;
    let interval = setInterval(function() {
        if (width >= 100) {
            clearInterval(interval);
            document.getElementById("dataStatus").textContent = "Data usage optimized!";
        } else {
            width++;
            progressBar.style.width = width + "%";
        }
    }, 50); // Adjust the speed of progress bar
});
