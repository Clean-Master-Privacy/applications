import os
import subprocess
import sys
import hashlib
import shutil
import sqlite3
import time
import tkinter as tk
from tkinter import scrolledtext
import threading
import matplotlib.pyplot as plt


def install(package):
    """Gerekli kütüphaneleri yükler."""
    subprocess.check_call([sys.executable, "-m", "pip", "install", package])


def check_and_install_libraries():
    """Gerekli kütüphanelerin yüklü olup olmadığını kontrol eder ve eksik olanları yükler."""
    required_packages = ["matplotlib"]
    for package in required_packages:
        try:
            __import__(package)
        except ImportError:
            print(f"{package} kütüphanesi yükleniyor...")
            install(package)


class CleanMasterPrivacy:
    MALICIOUS_EXTENSIONS = ['.exe', '.bat', '.cmd', '.scr', '.com']
    KNOWN_MALICIOUS_HASHES = ['5d41402abc4b2a76b9719d911017c592']  # Örnek hash değerleri
    SCAN_DIRECTORY = "C:/tarama_yapilacak_dizin"  # Kullanıcıdan aldık
    TEMPORARY_FILES_DIRS = ["/temp", "/temp", "/cache"]  # Geçici dosya dizinleri
    DATABASE_NAME = "tarama_results.db"

    def __init__(self):
        self.setup_environment()

    def setup_environment(self):
        """Gerekli dizin ve veritabanını ayarlar."""
        self.connect_to_database()

    def connect_to_database(self):
        try:
            self.conn = sqlite3.connect(self.DATABASE_NAME)
            self.cursor = self.conn.cursor()
            self.cursor.execute('''
                CREATE TABLE IF NOT EXISTS tarama_results (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    dosya_name TEXT,
                    dosya_path TEXT,
                    tarama_sonuclari TEXT,
                    tarih TEXT
                );
            ''')
            self.conn.commit()
        except Exception as e:
            print(f"Hata: {e}")

    def disconnect_from_database(self):
        if self.conn is not None:
            self.conn.close()

    def calculate_file_hash(self, filename):
        """Dosyanın hash değerini hesaplar."""
        with open(filename, "rb") as file:
            hash_md5 = hashlib.md5()
            for chunk in iter(lambda: file.read(4096), b""):
                hash_md5.update(chunk)
            return hash_md5.hexdigest()

    def check_is_malicious(self, file_path):
        """Dosyanın zararlı olup olmadığını kontrol eder."""
        if any(file_path.endswith(ext) for ext in self.MALICIOUS_EXTENSIONS):
            return True
        if self.calculate_file_hash(file_path) in self.KNOWN_MALICIOUS_HASHES:
            return True
        return False

    def scan_directory(self):
        """Verilen dizinde zararlı dosyaları tarar."""
        results = []
        for root, dirs, files in os.walk(self.SCAN_DIRECTORY):
            for file_name in files:
                file_path = os.path.join(root, file_name)
                if self.check_is_malicious(file_path):
                    result = f'Zararlı dosya bulundu: {file_path}'
                    results.append(result)
                    tarama_sonuc = f'Zararlı dosya bulundu: {file_path}'
                    self.cursor.execute('''
                        INSERT INTO tarama_results (dosya_name, dosya_path, tarama_sonuclari, tarih)
                        VALUES (?, ?, ?, ?);
                    ''', (file_name, file_path, tarama_sonuc, time.strftime("%Y-%m-%d %H:%M:%S")))
                    self.conn.commit()
        return results

    def clear_temporary_files(self):
        """Geçici dosyaları temizler."""
        for temp_dir in self.TEMPORARY_FILES_DIRS:
            path = os.path.expanduser("~") + temp_dir  # Kendi kullanıcı dizini
            if os.path.exists(path):
                shutil.rmtree(path)
                return f"Gereksiz dosya temizlendi: {path}"

        return "Temizlenecek geçici dosya bulunamadı"

    def cleanup_and_scan(self):
        results = self.scan_directory()
        cleanup_result = self.clear_temporary_files()
        return results, cleanup_result

    def generate_report(self):
        """Sistem durumu raporunu oluşturur."""
        malicious_files = self.cursor.execute("SELECT * FROM tarama_results").fetchall()
        report = f"Güvenlik Raporu\n\nZararlı Dosya Sayısı: {len(malicious_files)}\n\n"
        for item in malicious_files:
            report += f"Dosya Adı: {item[1]}, Dosya Yolu: {item[2]}, Sonuç: {item[3]}, Tarih: {item[4]}\n"
        return report

    def auto_report(self):
        """Her 2 saatte bir güvenlik raporu oluşturur."""
        while True:
            report = self.generate_report()
            print("Güvenlik raporu oluşturuldu.\n", report)
            self.plot_malicious_files_count()
            time.sleep(7200)  # 2 saat bekle (7200 saniye)

    def plot_malicious_files_count(self):
        """Zararlı dosyaların sayısını grafik olarak gösterir."""
        malicious_files = self.cursor.execute("SELECT * FROM tarama_results").fetchall()
        counts = len(malicious_files)
        
        plt.figure(figsize=(10, 5))
        plt.bar(['Zararlı Dosya Sayısı'], [counts], color='red')
        plt.title('Zararlı Dosyaların Sayısı')
        plt.xlabel('Durum')
        plt.ylabel('Sayısı')
        plt.ylim(0, max(10, counts + 1))  # Y eksenini ayarlayın
        plt.grid(axis='y')
        plt.show()


class App:
    def __init__(self, root):
        self.root = root
        self.root.title("Antivirüs ve Temizleme Uygulaması")
        self.root.geometry("600x400")

        self.start_button = tk.Button(root, text="Tara ve Temizle", command=self.start_cleanup_and_scan)
        self.start_button.pack(pady=10)

        self.result_area = scrolledtext.ScrolledText(root, width=70, height=20)
        self.result_area.pack(pady=10)

        self.app = CleanMasterPrivacy()
        # Otomatik raporlama işlemini başlatıyoruz
        threading.Thread(target=self.app.auto_report, daemon=True).start()  # Daemon thread

    def start_cleanup_and_scan(self):
        self.result_area.delete(1.0, tk.END)  # Önceki sonuçları temizle
        self.result_area.insert(tk.END, "Taramaya başlıyor...\n")
        results, cleanup_result = self.app.cleanup_and_scan()

        if results:
            self.result_area.insert(tk.END, "\n".join(results) + "\n")
        else:
            self.result_area.insert(tk.END, "Zararlı dosya bulunamadı.\n")

        self.result_area.insert(tk.END, cleanup_result)


if __name__ == "__main__":
    check_and_install_libraries()  # Gerekli kütüphaneleri kontrol et ve yükle
    root = tk.Tk()
    app = App(root)
    root.mainloop()
