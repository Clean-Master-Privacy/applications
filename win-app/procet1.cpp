#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <filesystem>
#include <openssl/md5.h>
#include <openssl/sha.h>

using namespace std;
namespace fs = std::filesystem;

// Bilinen zararlı yazılımların MD5 ve SHA-1 hash'leri (örneğin)
const vector<pair<string, string>> knownMalwareHashes = {
    {"e99a18c428cb38d5f260853678922e03", "Malware Sample 1", "md5"},
    {"0c2d8a5a7f0d3c4f2e5b6a8b9c7a6d5a4f3e2d1", "Malware Sample 2", "sha1"},
};

// MD5 hesaplama fonksiyonu
void calculateMD5(const string &filePath, string &hash) {
    unsigned char digest[MD5_DIGEST_LENGTH];
    char buffer[8192];
    MD5_CTX ctx;
    MD5_Init(&ctx);

    ifstream file(filePath, ios::binary);
    if (!file.is_open()) {
        cerr << "Unable to open file: " << filePath << endl;
        return;
    }

    while (file.read(buffer, sizeof(buffer))) {
        MD5_Update(&ctx, buffer, file.gcount());
    }
    file.close();
    MD5_Final(digest, &ctx);

    hash.resize(MD5_DIGEST_LENGTH * 2);
    for (int i = 0; i < MD5_DIGEST_LENGTH; i++) {
        sprintf(&hash[i * 2], "%02x", (unsigned int)digest[i]);
    }
}

// Dizin tarama fonksiyonu
void scanDirectory(const string &directory) {
    for (const auto &entry : fs::directory_iterator(directory)) {
        if (entry.is_regular_file()) {
            string filePath = entry.path().string();
            string fileHash;

            // MD5 hesapla
            calculateMD5(filePath, fileHash);
            for (const auto &malware : knownMalwareHashes) {
                if (fileHash == malware.first) {
                    cout << "Malware detected: " << filePath << " -> " << malware.second << endl;
                }
            }
        }
    }
}

int main() {
    string directory;

    cout << "Antivirus Scanner" << endl;
    cout << "Enter directory to scan: ";
    cin >> directory;

    scanDirectory(directory);

    cout << "Scan completed." << endl;
    return 0;
}
