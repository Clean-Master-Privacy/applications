import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VirusScanner {
    public static void scanForVirus(String filename) {
        String virusSignature = "Trojan1234";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(virusSignature)) {
                    System.out.println("Virüs tespit edildi: " + virusSignature);
                }
            }
        } catch (IOException e) {
            System.out.println("Dosya açılmadı.");
        }
    }

    public static void main(String[] args) {
        scanForVirus("test_file.txt");
    }
}

