import os
import hashlib

# List of malicious file extensions
malicious_extensions = ['.exe', '.bat', '.cmd', '.scr', '.com']
# Predefined malicious hashes (for example purposes)
known_malicious_hashes = ['5d41402abc4b2a76b9719d911017c592', 'd41d8cd98f00b204e9800998ecf8427e']  # Example hashes

def get_file_hash(filename):
    """Calculate the MD5 hash of the given file."""
    hash_md5 = hashlib.md5()
    try:
        with open(filename, "rb") as f:
            for chunk in iter(lambda: f.read(4096), b""):
                hash_md5.update(chunk)
    except Exception as e:
        print(f"Error reading file {filename}: {e}")
    return hash_md5.hexdigest()

def log_malicious_file(file_path, log_file):
    """Log the detected malicious file into the log file."""
    with open(log_file, 'a') as log:
        log.write(file_path + '\n')

def is_file_malicious(file_path):
    """Check if the file is potentially malicious."""
    # Check for malicious extension
    if any(file_path.endswith(ext) for ext in malicious_extensions):
        return True
    # Check file hash against known malicious hashes
    if get_file_hash(file_path) in known_malicious_hashes:
        return True
    return False

def scan_directory(directory, log_file):
    """Scan the given directory for malicious files."""
    for root, dirs, files in os.walk(directory):
        for file_name in files:
            file_path = os.path.join(root, file_name)
            # Check if the file is malicious
            if is_file_malicious(file_path):
                print(f'Potential malicious file found: {file_path}')
                log_malicious_file(file_path, log_file)

if __name__ == "__main__":
    directory_to_scan = input("Enter the directory to scan: ")
    log_filename = "malicious_files_log.txt"

    if os.path.isdir(directory_to_scan):
        print(f"Scanning directory: {directory_to_scan}\n")
        scan_directory(directory_to_scan, log_filename)
        print(f"\nScan complete. Malicious files logged in: {log_filename}")
    else:
        print("Invalid directory. Please enter a valid directory path.")
