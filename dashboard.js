// Clean Cache
document.getElementById("cleanCacheBtn").addEventListener("click", function() {
    document.getElementById("cleanCacheStatus").textContent = "Cleaning cache and cookies...";
    setTimeout(() => {
        document.getElementById("cleanCacheStatus").textContent = "Cache and cookies cleaned successfully!";
    }, 2000); // Simulate cleaning process with a delay
});

// Optimize Performance
document.getElementById("optimizePerformanceBtn").addEventListener("click", function() {
    document.getElementById("performanceStatus").textContent = "Optimizing system performance...";
    setTimeout(() => {
        document.getElementById("performanceStatus").textContent = "Performance optimized!";
    }, 2000); // Simulate optimization process
});

// Save Data
document.getElementById("saveDataBtn").addEventListener("click", function() {
    document.getElementById("dataStatus").textContent = "Optimizing data usage...";
    setTimeout(() => {
        document.getElementById("dataStatus").textContent = "Data usage optimized!";
    }, 2000); // Simulate data saving process
});
