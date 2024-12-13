from flask import Flask, render_template, request, jsonify
import os
import time
import shutil
from clamd import ClamdUnixSocket
import subprocess

app = Flask(__name__)

# Yükleme dizini (uploads) ve cache dizini
UPLOAD_FOLDER = 'uploads'
CACHE_DIR = 'cache_files'
if not os.path.exists(UPLOAD_FOLDER):
    os.makedirs(UPLOAD_FOLDER)
if not os.path.exists(CACHE_DIR):
    os.makedirs(CACHE_DIR)

# ClamAV Client Bağlantısı (Clamd)
clamd = ClamdUnixSocket()

# Dosya uzantı kontrolü
ALLOWED_EXTENSIONS = {'txt', 'pdf', 'png', 'jpg', 'jpeg', 'gif', 'zip', 'tar', 'tar.gz'}

def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/upload', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return jsonify({'status': 'error', 'message': 'No file part'})
    
    file = request.files['file']
    
    if file.filename == '':
        return jsonify({'status': 'error', 'message': 'No selected file'})
    
    if file and allowed_file(file.filename):
        # Define file path
        file_path = os.path.join(UPLOAD_FOLDER, file.filename)
        file.save(file_path)

        # ClamAV ile antivirüs taraması yap
        result = clamd.scan(file_path)
        if result[file_path][0] == 'FOUND':
            return jsonify({'status': 'error', 'message': 'Virus found in the file!'})

        # C ve C++ ile virüs veritabanı işleme
        c_result = subprocess.run(["./c_code/clean_database", file_path], capture_output=True, text=True)
        if "virus_found" in c_result.stdout:
            return jsonify({'status': 'error', 'message': 'Virus detected in the file! (C/C++)'})

        return jsonify({
            'status': 'success', 
            'message': 'File uploaded and no virus detected!', 
            'filepath': file_path,
            'scan_result': {
                'status': 'no-virus',
                'viruses_found': 0
            }
        })
    else:
        return jsonify({'status': 'error', 'message': 'File type not allowed'})

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
    # Simulate performance optimization
    time.sleep(2)  # Simulate a delay for optimization
    return jsonify({"status": "success", "message": "Device optimized!"}), 200

@app.route('/save_data', methods=['POST'])
def save_data():
    # Simulate saving data
    time.sleep(2)  # Simulate a delay for data saving
    return jsonify({"status": "success", "message": "Data usage optimized!"}), 200

if __name__ == '__main__':
    app.run(debug=True)
