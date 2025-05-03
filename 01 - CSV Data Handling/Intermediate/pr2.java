package Day23.Intermediate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class pr2 {
    public static void main(String[] args) {
        String fileName = "D:\\Capgemini\\Java\\src\\Day23\\Intermediate\\employees.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            boolean found = lines.stream()
                    .skip(1) // skip header
                    .map(line -> line.split(","))
                    .filter(fields -> fields[1].equalsIgnoreCase(searchName))
                    .peek(fields -> {
                        System.out.println("Department: " + fields[2]);
                        System.out.println("Salary: " + fields[3]);
                    })
                    .findFirst()
                    .isPresent();

            if (!found) {
                System.out.println("Employee '" + searchName + "' not found.");
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
