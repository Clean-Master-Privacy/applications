#include <iostream>
#include <fstream>
#include <string>

int main() {
    std::ifstream file("virus_db.txt");
    std::string line;
    while (std::getline(file, line)) {
        if (line.find("infected_file_signature") != std::string::npos) {
            std::cout << "Virus found!" << std::endl;
            return 1;
        }
    }
    std::cout << "No viruses found." << std::endl;
    return 0;
}
