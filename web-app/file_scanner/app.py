from flask import Flask, render_template, jsonify
import time
import random

app = Flask(__name__)

# Simulated files to be found during the scan
fake_files = [f"file_{i}.txt" for i in range(1, 101)]

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/scan')
def scan():
    found_files = []
    total_size = 0

    # Simulate a scanning process with a delay
    for file in fake_files:
        # Randomly assign a size to each file (1 - 1000 bytes)
        size = random.randint(1, 1000)
        time.sleep(0.1)  # Simulate scanning time
        found_files.append(file)
        total_size += size

    return jsonify({'found_files': found_files, 'total_size': total_size})

if __name__ == '__main__':
    app.run(debug=True)
