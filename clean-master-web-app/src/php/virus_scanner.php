<?php
function scan_for_virus($filename) {
    $virus_signature = "Trojan1234";
    $file = fopen($filename, "r");

    if ($file) {
        while (($line = fgets($file)) !== false) {
            if (strpos($line, $virus_signature) !== false) {
                echo "Virüs tespit edildi: " . $virus_signature . "\n";
            }
        }
        fclose($file);
    } else {
        echo "Dosya açılamadı.\n";
    }
}

scan_for_virus("test_file.txt");
?>

