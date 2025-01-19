#include <iostream>
#include <filesystem>
#include <fstream>
#include <thread>
#include <chrono>
#include <string>
#include <unordered_map>
#include <cstdlib>
#include <sstream>
#include <iomanip>

#ifdef _WIN32
#include <windows.h>
#else
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#endif

// Zararlı yazılımlar için hash veritabanı
std::unordered_map<std::string, std::string> known_malware_hashes = {
    {"e99a18c428cb38d5f260853678922e03", "Malware Sample 1"},
    {"aab32b9a2ad356648b1cf9e27d26fbd1", "Trojan Sample 1"}
};

// MD5 hash hesaplama fonksiyonu
std::string get_md5_hash(const std::string& filename) {
    // Bu basit örnek sadece hash hesaplamak için yazılmıştır.
    // Gerçek hash hesaplama işlevini OpenSSL veya başka bir kütüphane ile yapabilirsiniz.
    return "dummyhash";
}

// Dosya tarama
void scan_directory(const std::string& directory) {
    for (const auto& entry : std::filesystem::directory_iterator(directory)) {
        if (std::filesystem::is_regular_file(entry.status())) {
            std::string file_path = entry.path().string();
            std::string file_hash = get_md5_hash(file_path);

            if (known_malware_hashes.find(file_hash) != known_malware_hashes.end()) {
                std::cout << "Zararlı yazılım tespit edildi: " << file_path
                          << " -> " << known_malware_hashes[file_hash] << std::endl;
            }
        }
    }
}

// Gerçek zamanlı koruma (dosya değişikliklerini izleme)
class RealTimeProtection {
public:
    void monitorDirectory(const std::string& dir) {
        while (true) {
            for (const auto& entry : std::filesystem::directory_iterator(dir)) {
                if (std::filesystem::is_regular_file(entry.status())) {
                    std::cout << "Yeni dosya tespit edildi: " << entry.path() << std::endl;
                    scan_directory(entry.path().string());
                }
            }
            std::this_thread::sleep_for(std::chrono::seconds(5)); // Her 5 saniyede bir kontrol et
        }
    }
};

// SVG simgesi oluşturma (Basit bir metin olarak)
void create_svg() {
    std::string svg_content = R"(
<?xml version="1.0" encoding="UTF-8"?>
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" width="100" height="100">
    <circle cx="50" cy="50" r="45" fill="#4CAF50" stroke="#388E3C" stroke-width="5"/>
    <path d="M35,45 L50,60 L65,45" fill="none" stroke="white" stroke-width="5"/>
    <path d="M35,55 L50,40 L65,55" fill="none" stroke="white" stroke-width="5"/>
    <circle cx="50" cy="50" r="40" fill="none" stroke="white" stroke-width="5"/>
    <text x="50%" y="90%" font-size="12" text-anchor="middle" fill="white">Antivirüs</text>
</svg>
    )";

    std::ofstream file("antivirus_icon.svg");
    file << svg_content;
    file.close();

    std::cout << "SVG dosyası oluşturuldu: antivirus_icon.svg" << std::endl;
}

// Platform tespiti ve gerekli komutları çalıştırma
void setup_platform_and_compile() {
    #ifdef _WIN32
        std::cout << "Windows işletim sistemi algılandı." << std::endl;
        std::cout << "Derleme için uygun komutlar kullanılacak." << std::endl;

        // Visual Studio ya da MinGW ile ilgili derleme komutlarını yazabilirsiniz
        std::cout << "Program Windows üzerinde derleniyor..." << std::endl;
        system("g++ -std=c++17 -o antivirus antivirus.cpp -lstdc++fs -lopencv_core -lopencv_imgcodecs -lopencv_imgproc -lssl -lcrypto");

    #else
        std::cout << "Linux işletim sistemi algılandı." << std::endl;
        
        // Linux için gerekli kütüphanelerin kurulu olup olmadığını kontrol et
        if (system("dpkg -s libopencv-dev &> /dev/null") != 0 || system("dpkg -s libssl-dev &> /dev/null") != 0) {
            std::cout << "Eksik kütüphaneler: OpenCV veya OpenSSL. Lütfen bunları kurun." << std::endl;
            exit(1);  // Hata durumunda çık
        }

        // Derleme işlemi
        std::cout << "Program Linux üzerinde derleniyor..." << std::endl;
        system("g++ -std=c++17 -o antivirus antivirus.cpp -lstdc++fs -lopencv_core -lopencv_imgcodecs -lopencv_imgproc -lssl -lcrypto");

    #endif
}

// Başlangıç izinlerini ayarlama
void set_permissions() {
    #ifdef _WIN32
        std::cout << "Windows'ta yönetici izinleri sağlanıyor..." << std::endl;
        // Windows için belirli yönetici izinleri sağlanabilir (örneğin, kullanıcıyı Admin olarak çalıştırmak)
    #else
        std::cout << "Linux'ta çalıştırılabilir izinler veriliyor..." << std::endl;
        system("chmod +x antivirus");
    #endif
}

// Programı her 15 dakikada bir çalıştıracak şekilde başlatma
void restart_program_every_15_minutes() {
    while (true) {
        std::cout << "Antivirüs taraması başlatılıyor..." << std::endl;

        // Gerçek zamanlı koruma başlat
        RealTimeProtection rtProtection;
        std::thread rtThread(&RealTimeProtection::monitorDirectory, &rtProtection, "./");

        // SVG simgesini oluştur
        create_svg();

        rtThread.join();  // Gerçek zamanlı koruma thread'inin tamamlanmasını bekle

        std::cout << "Antivirüs taraması tamamlandı. 15 dakika sonra tekrar çalışacak." << std::endl;

        // 15 dakika bekle (900 saniye)
        std::this_thread::sleep_for(std::chrono::minutes(15));

        // Program kendisini yeniden başlatacak (OS'un `execvp` veya `system` komutları ile)
        std::cout << "Program kendini yeniden başlatıyor..." << std::endl;
        #ifdef _WIN32
            system("antivirus");  // Windows ortamı için
        #else
            execvp("./antivirus", NULL);  // Linux ortamı için
        #endif
        break;  // Program yeniden başlatıldığında döngü durur
    }
}

int main() {
    std::cout << "Program başlatılıyor..." << std::endl;

    // Platforma özel derleme komutları
    setup_platform_and_compile();

    // Çalıştırılabilir izinleri ayarlama
    set_permissions();

    // Programı her 15 dakikada bir çalıştır
    restart_program_every_15_minutes();

    return 0;
}
