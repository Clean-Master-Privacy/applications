#include <stdio.h>
#include <string.h>

void scan_for_virus(const char *filename) {
    FILE *file = fopen(filename, "r");
    char buffer[1024];
    const char *virus_signature = "Trojan1234";

    if (file == NULL) {
        printf("Dosya açılmadı\n");
        return;
    }

    while (fgets(buffer, sizeof(buffer), file)) {
        if (strstr(buffer, virus_signature)) {
            printf("Virüs tespit edildi: %s\n", virus_signature);
        }
    }
    fclose(file);
}

int main() {
    scan_for_virus("test_file.txt");
    return 0;
}

