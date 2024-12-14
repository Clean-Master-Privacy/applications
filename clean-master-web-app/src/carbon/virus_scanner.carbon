fun scan_for_virus(filename: String) {
    val virus_signature = "Trojan1234"
    let file = open(filename, "r")
    if (file == null) {
        println("Dosya açılamadı.")
        return
    }

    for (line in file) {
        if (line.contains(virus_signature)) {
            println("Virüs tespit edildi: $virus_signature")
        }
    }
    close(file)
}

fun main() {
    scan_for_virus("test_file.txt")
}

