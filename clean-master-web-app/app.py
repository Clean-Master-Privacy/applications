from flask import Flask, request, jsonify, render_template
import os

app = Flask(__name__)

# Virus database (dummy)
virus_db = {
    "example_virus": "This is a known virus!",
}

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/scan_file', methods=['POST'])
def scan_file():
    # Simulate scanning a file
    uploaded_file = request.files['file']
    file_content = uploaded_file.read().decode('utf-8')  # Read file content as text
    
    # Simple virus scan simulation
    for virus_name, virus_description in virus_db.items():
        if virus_name in file_content:
            return jsonify({"result": f"Virus found: {virus_name} - {virus_description}"})
    
    return jsonify({"result": "No viruses detected."})

if __name__ == '__main__':
    app.run(debug=True)
