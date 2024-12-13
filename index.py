from flask import Flask, render_template_string, jsonify
import os

app = Flask(__name__)

# Temporary directory for cache files (for simulation)
CACHE_DIR = "cache_files"  # Simulate cache directory

# Create the cache directory if it doesn't exist
if not os.path.exists(CACHE_DIR):
    os.makedirs(CACHE_DIR)

# Simulate files in cache directory
for i in range(1, 6):
    with open(f"{CACHE_DIR}/file{i}.tmp", "w") as f:
        f.write(f"Temporary data for file {i}")

@app.route('/')
def home():
    # The HTML code is embedded directly within the Python file
    return render_template_string('''
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clean Master Web</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: white;
            width: 80%;
            max-width: 600px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 15px;
            background-color: #28a745;
            border: none;
            color: white;
            font-size: 16px;
            cursor: pointer;
            margin-bottom: 20px;
            border-radius: 5px;
            transition: 0.3s;
        }
        .btn:hover {
            background-color: #218838;
        }
        .status {
            margin-top: 20px;
            text-align: center;
            font-size: 16px;
            color: #333;
        }
        .alert {
            color: red;
            font-size: 14px;
            margin-top: 10px;
            text-align: center;
        }
        .info {
            color: #17a2b8;
            font-size: 14px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Clean Master Web</h1>
        
        <button class="btn" id="cleanFilesBtn">Clean Cache & Cookies</button>
        <button class="btn" id="optimizePerformanceBtn">Optimize Performance</button>
        <button class="btn" id="saveDataBtn">Save Data</button>
        
        <div class="status" id="status"></div>
        <div class="alert" id="errorAlert"></div>
        <div class="info" id="info"></div>
    </div>

    <script>
        // Clean cache & cookies functionality
        document.getElementById("cleanFilesBtn").addEventListener("click", function() {
            document.getElementById("status").textContent = "Cleaning cache and cookies...";
            fetch("/clean_cache", { method: "POST" })
                .then(response => response.json())
                .then(data => {
                    if (data.status === "success") {
                        document.getElementById("status").textContent = data.message;
                    }
                })
                .catch(error => {
                    document.getElementById("errorAlert").textContent = "Error cleaning cache.";
                });
        });

        // Optimize performance simulation
        document.getElementById("optimizePerformanceBtn").addEventListener("click", function() {
            document.getElementById("status").textContent = "Optimizing performance...";
            fetch("/optimize_performance", { method: "POST" })
                .then(response => response.json())
                .then(data => {
                    document.getElementById("status").textContent = data.message;
                });
        });

        // Data saving simulation
        document.getElementById("saveDataBtn").addEventListener("click", function() {
            document.getElementById("status").textContent = "Optimizing data usage...";
            fetch("/save_data", { method: "POST" })
                .then(response => response.json())
                .then(data => {
                    document.getElementById("status").textContent = data.message;
                });
        });
    </script>

</body>
</html>
    ''')

@app.route('/clean_cache', methods=['POST'])
def clean_cache():
    files_deleted = []
    for filename in os.listdir(CACHE_DIR):
        file_path = os.path.join(CACHE_DIR, filename)
        try:
            os.remove(file_path)
            files_deleted.append(filename)
        except Exception as e:
            return jsonify({"status": "error", "message": str(e)}), 500

    return jsonify({"status": "success", "message": f"Deleted files: {files_deleted}"}), 200

@app.route('/optimize_performance', methods=['POST'])
def optimize_performance():
    return jsonify({"status": "success", "message": "Device optimized!"}), 200

@app.route('/save_data', methods=['POST'])
def save_data():
    return jsonify({"status": "success", "message": "Data usage optimized!"}), 200

if __name__ == "__main__":
    app.run(debug=True)
