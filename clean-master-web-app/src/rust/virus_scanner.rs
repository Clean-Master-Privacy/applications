use std::fs::File;
use std::io::{self, BufRead};
use std::path::Path;

fn scan_for_virus(filename: &str) {
    let virus_signature = "Trojan1234";
    let file = File::open(filename).expect("Dosya açılamadı");
    let reader = io::BufReader::new(file);

    for line in reader.lines() {
        let line = line.expect("Satır okunamadı");
        if line.contains(virus_signature) {
            println!("Virüs tespit edildi: {}", virus_signature);
        }
    }
}

fn main() {
    scan_for_virus("test_file.txt");
}

