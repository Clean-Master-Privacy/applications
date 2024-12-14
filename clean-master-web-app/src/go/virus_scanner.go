package main

import (
    "bufio"
    "fmt"
    "os"
    "strings"
)

func scanForVirus(filename string) {
    virusSignature := "Trojan1234"
    file, err := os.Open(filename)
    if err != nil {
        fmt.Println("Dosya açılamadı:", err)
        return
    }
    defer file.Close()

    scanner := bufio.NewScanner(file)
    for scanner.Scan() {
        if strings.Contains(scanner.Text(), virusSignature) {
            fmt.Println("Virüs tespit edildi:", virusSignature)
        }
    }
}

func main() {
    scanForVirus("test_file.txt")
}

