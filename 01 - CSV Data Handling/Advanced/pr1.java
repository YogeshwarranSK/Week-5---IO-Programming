package Day23.Advanced;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class pr1 {
    public static void main(String[] args) {
        String fileName = "D:\\Capgemini\\Java\\src\\Day23\\Advanced\\contacts.csv";

        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            lines.stream()
                    .skip(1)
                    .map(line -> line.split(",", -1))
                    .forEach(fields -> {
                        String id = fields[0];
                        String name = fields[1];
                        String email = fields[2];
                        String phone = fields[3];

                        boolean emailValid = emailPattern.matcher(email).matches();
                        boolean phoneValid = phonePattern.matcher(phone).matches();

                        if (!emailValid || !phoneValid) {
                            System.out.println(" Invalid Record: ID " + id + ", Name: " + name);
                            if (!emailValid) System.out.println("   → Invalid Email: " + email);
                            if (!phoneValid) System.out.println("   → Invalid Phone: " + phone);
                            System.out.println("------------------------");
                        }
                    });

        } catch (IOException e) {
            System.err.println(" Error reading the file: " + e.getMessage());
        }
    }
}

