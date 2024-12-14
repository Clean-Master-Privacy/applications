section .data
virus_signature db "Trojan1234", 0
file_to_scan db "test_file.txt", 0

section .bss
buffer resb 1024

section .text
global _start

_start:
; Open file
; A file read and virus signature comparison will be done here
; (This is just a basic example; the actual scan function will be more complex.)
; Further steps can be added here.
; More ASM code will be here.
mov eax, 1 ; exit code
int 0x80
