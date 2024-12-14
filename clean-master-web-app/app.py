from flask import Flask, render_template, jsonify
import os

app = Flask(__name__)

CACHE_DIR = "cache_files"

# Cache dosyalarını simüle et
if not os.path.exists(CACHE_DIR):
    os.makedirs(CACHE_DIR)

for i in range(1, 6):
    with open(f"{CACHE_DIR}/file{i}.tmp", "w") as f:
        f.write(f"Temporary data for file {i}")

@app.route('/')
def home():
    return render_template('index.html')

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
