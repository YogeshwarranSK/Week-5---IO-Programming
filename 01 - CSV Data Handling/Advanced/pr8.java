package Day23.Advanced;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.io.*;

public class pr8 {
    private static final String key = "1234567890123456";

    public static String encrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(value));
        return new String(original);
    }

    public static void writeEncryptedCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Email,Salary\n");
            writer.write("201,Alice," + encrypt("alice@example.com") + "," + encrypt("70000") + "\n");
            writer.write("202,Bob," + encrypt("bob@example.com") + "," + encrypt("68000") + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readDecryptedCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String email = decrypt(parts[2]);
                String salary = decrypt(parts[3]);
                System.out.println(parts[0] + "," + parts[1] + "," + email + "," + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "encrypted_employees.csv";
        writeEncryptedCSV(filePath);
        readDecryptedCSV(filePath);
    }
}
