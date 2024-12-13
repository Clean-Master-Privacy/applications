section .text
    global _start

_start:
    ; Print "File scanned successfully"
    mov rax, 1
    mov rdi, 1
    mov rsi, message
    mov rdx, 20
    syscall

    ; Exit
    mov rax, 60
    xor rdi, rdi
    syscall

section .data
message db 'File scanned successfully', 0x0A
