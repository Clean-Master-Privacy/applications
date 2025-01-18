import os
import subprocess
import sys
import sqlite3
import platform
import logging
import requests
from datetime import datetime

# Hata Loglama Ayarları
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

# DeepAI API Anahtarınızı buraya ekleyin
DEEPAI_API_KEY = '9fe9b9a7-64fa-4e5f-b7ee-4c5997f8531b'
DATABASE_NAME = "maintenance_results.db"

class AutomatedDebugger:
    """
    Basit bir hata ayıklama ve öneri sistemi.
    """
    def suggest_fixes(self, error_message):
        suggestions = []
        
        if "module" in error_message and "not found" in error_message:
            suggestions.append("Gerekli modülü yüklemeyi deneyin veya modül adını kontrol edin.")
        if "permission denied" in error_message:
            suggestions.append("Erişim izninizi kontrol edin.")
        if "no such file" in error_message:
            suggestions.append("Dosya veya dizinin mevcut olduğundan emin olun.")
        
        return suggestions

def install(package):
    """Dış bağımlılıkları yüklemek için kullanılan fonksiyon."""
    try:
        subprocess.check_call([sys.executable, "-m", "pip", "install", package])
        logging.info(f"{package} başarıyla yüklendi.")
    except Exception as e:
        logging.error(f"{package} yüklenirken hata: {e}")

def verify_dependencies():
    """Gerekli bağımlılıkların yüklü olup olmadığını kontrol eder ve gerekirse yükler."""
    required_modules = ['sqlite3', 'requests']  
    for module in required_modules:
        try:
            __import__(module)
        except ImportError:
            logging.warning(f"{module} eksik, yükleniyor...")
            install(module)

def setup_database():
    try:
        conn = sqlite3.connect(DATABASE_NAME)
        cursor = conn.cursor()
        cursor.execute('''
            CREATE TABLE IF NOT EXISTS maintenance_log (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                operation TEXT,
                description TEXT,
                timestamp TEXT
            );
        ''')
        conn.commit()
        logging.info("Veritabanı başarıyla oluşturuldu.")
    except sqlite3.Error as e:
        logging.error(f"Veritabanı hatası: {e}")
        debugger = AutomatedDebugger()
        suggestions = debugger.suggest_fixes(str(e))
        logging.info("Öneriler: " + "; ".join(suggestions))

def log_operation(operation, description):
    """Operasyonları veritabanına kaydet."""
    try:
        conn = sqlite3.connect(DATABASE_NAME)
        cursor = conn.cursor()
        cursor.execute('''
            INSERT INTO maintenance_log (operation, description, timestamp)
            VALUES (?, ?, ?);
        ''', (operation, description, datetime.now().isoformat()))
        conn.commit()
    except sqlite3.Error as e:
        logging.error(f"Log kaydı oluşturulurken hata: {e}")
        debugger = AutomatedDebugger()
        suggestions = debugger.suggest_fixes(str(e))
        logging.info("Öneriler: " + "; ".join(suggestions))

def perform_disk_cleanup():
    """Geçici dosyaları temizler."""
    temp_dir = os.path.join(os.path.expanduser("~"), "AppData", "Local", "Temp")
    
    if not os.path.exists(temp_dir):
        logging.error(f"{temp_dir} dizini bulunamadı.")
        return "Hata: Dizine erişilemiyor."
    
    try:
        opened_files = os.listdir(temp_dir)
        for file in opened_files:
            try:
                os.remove(os.path.join(temp_dir, file))
                logging.info(f"{file} silindi.")
            except Exception as e:
                logging.error(f"Sorun: {e}. {file} silinemedi.")
                debugger = AutomatedDebugger()
                suggestions = debugger.suggest_fixes(str(e))
                logging.info("Öneriler: " + "; ".join(suggestions))
        
        result = "Disk temizleme tamamlandı."
    except Exception as e:
        result = f"Hata: {e}"
    
    log_operation("Disk Temizleme", result)
    return result

def display_system_info():
    """Sistem bilgilerini gösterir."""
    try:
        system_info = (
            f"Platform: {platform.system()}\n"
            f"Platform Sürümü: {platform.version()}\n"
            f"İşlemci: {platform.processor()}\n"
            f"Mimari: {platform.architecture()[0]}\n"
        )
        return system_info
    except Exception as e:
        return f"Sistem bilgileri alınamadı: {e}"

def virus_scan():
    """Kötü niyetli dosyaları tarar."""
    user_files = os.path.expanduser("~")  # Kullanıcının ana dizini
    found_malicious_files = []
    malicious_extensions = ['.exe', '.bat', '.cmd']  

    for dirpath, dirnames, filenames in os.walk(user_files):
        for filename in filenames:
            if any(filename.endswith(ext) for ext in malicious_extensions):
                found_malicious_files.append(os.path.join(dirpath, filename))

    if found_malicious_files:
        logging.warning("Kötü niyetli dosyalar bulundu:")
        for malicious_file in found_malicious_files:
            logging.warning(f"Bulundu: {malicious_file}")
        result = "Kötü niyetli dosyalar bulundu."
    else:
        logging.info("Kötü niyetli dosya bulunmadı.")
        result = "Kötü niyetli dosya bulunmadı."
    
    log_operation("Virüs Taraması", result)
    return result

def fix_code_with_deepai(code):
    """DeepAI API'si kullanarak kodu düzeltir."""
    try:
        response = requests.post(
            "https://api.deepai.org/api/code-detection",
            data={'code': code},
            headers={'api-key': DEEPAI_API_KEY}
        )
        return response.json().get('output', 'Düzeltme yapılamadı.')
    except Exception as e:
        logging.error(f"DeepAI API çağrılırken hata: {e}")
        return "API ile iletişimde bir sorun oluştu."

def main():
    """Programın ana işlevi."""
    verify_dependencies()  
    setup_database()
    
    while True:
        print("\nYapmak istediğiniz işlemi seçin:")
        print("1. Disk Temizleme")
        print("2. Sistem Bilgilerini Göster")
        print("3. Virüs Taraması Yap")
        print("4. Kodu Düzelt (DeepAI)")
        print("5. Çıkış")

        choice = input("Seçiminizi girin (1/2/3/4/5): ")
        
        if choice == '1':
            print("Disk Temizleme Yapılıyor...")
            result = perform_disk_cleanup()
            print(result)
        elif choice == '2':
            print("Sistem Bilgileri Gösteriliyor...")
            system_info = display_system_info()
            print(system_info)
        elif choice == '3':
            print("Virüs Taraması Yapılıyor...")
            scan_result = virus_scan()
            print(scan_result)
        elif choice == '4':
            code_to_fix = input("Düzeltmek istediğiniz kodu girin: ")
            fixed_code = fix_code_with_deepai(code_to_fix)
            print("Düzeltilmiş Kod:")
            print(fixed_code)
        elif choice == '5':
            print("Programdan çıkılıyor.")
            break
        else:
            print("Geçersiz seçim. Lütfen 1, 2, 3, 4 veya 5 girin.")

    input("Çıkmak için bir tuşa basın...")

if __name__ == "__main__":
    try:
        main()
    except Exception as e:
        logging.error(f"Program çalışırken hata oluştu: {e}")
        debugger = AutomatedDebugger()
        suggestions = debugger.suggest_fixes(str(e))
        logging.info("Öneriler: " + "; ".join(suggestions))
        input("Bir hata oluştu. Çıkmak için bir tuşa basın...")
