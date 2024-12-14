#include <iostream>
#include <fstream>
#include <string>

class VirusScanner {
public:
    void scan_for_virus(const std::string &filename) {
        std::ifstream file(filename);
        std::string line;
        const std::string virus_signature = "Trojan1234";

        if (!file.is_open()) {
            std::cerr << "Dosya açılamadı." << std::endl;
            return;
        }

        while (std::getline(file, line)) {
            if (line.find(virus_signature) != std::string::npos) {
                std::cout << "Virüs tespit edildi: " << virus_signature << std::endl;
            }
        }

        file.close();
    }
};

int main() {
    VirusScanner scanner;
    scanner.scan_for_virus("test_file.txt");
    return 0;
}

