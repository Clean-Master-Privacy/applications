#include <stdio.h>
extern void assembly_function();  // Assembly fonksiyonunu dışarıdan çağırıyoruz

int main() {
    assembly_function();
    return 0;
}
