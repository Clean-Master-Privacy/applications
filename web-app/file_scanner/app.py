from flask import Flask, request, jsonify
import os

app = Flask(__name__)

@app.route('/scan', methods=['POST'])
def scan_and_delete():
    directory = request.json.get('directory')
    
    if not directory or not os.path.isdir(directory):
        return jsonify({"error": "Geçersiz dizin"}), 400

    deleted_files = []
    
    # Dizin içindeki gereksiz dosyaları kontrol et
    for filename in os.listdir(directory):
        if any(filename.endswith(ext) for ext in ['.tmp', '.log', '.bak']):
            file_path = os.path.join(directory, filename)
            os.remove(file_path)
            deleted_files.append(filename)

    return jsonify({"deleted_files": deleted_files}), 200

@app.route('/list_files', methods=['POST'])
def list_files():
    directory = request.json.get('directory')
    
    if not directory or not os.path.isdir(directory):
        return jsonify({"error": "Geçersiz dizin"}), 400

    file_paths = []
    
    # Dizin içindeki dosyaların tam yollarını kontrol et
    for filename in os.listdir(directory):
        file_paths.append(os.path.join(directory, filename))

    return jsonify({"files": file_paths}), 200

if __name__ == '__main__':
    app.run(debug=True)
