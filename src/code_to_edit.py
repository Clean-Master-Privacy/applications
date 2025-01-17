import os

# AI Modeli
from model.ai_model import correct_text

# Dosyayı oku
def read_file(file_path):
    with open(file_path, 'r') as file:
        return file.read()

# Dosyayı yaz
def write_to_file(file_path, text):
    with open(file_path, 'w') as file:
        file.write(text)

def main():
    # Dosya yolu (GitHub'dan alınacak)
    file_path = "example_code.py"
    
    # Dosyayı oku
    original_text = read_file(file_path)
    print("Orijinal Metin: ", original_text)
    
    # Yapay Zeka ile düzelt
    corrected_text = correct_text(original_text)
    
    # Düzeltmeleri dosyaya yaz
    write_to_file(file_path, corrected_text)
    print("Düzeltilmiş Metin: ", corrected_text)

if __name__ == "__main__":
    main()
