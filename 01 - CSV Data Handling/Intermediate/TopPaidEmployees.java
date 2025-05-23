package Day23.Intermediate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TopPaidEmployees {
    public static void main(String[] args) {
        String fileName = "employees.csv";

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            List<String[]> sorted = lines.stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .sorted((a, b) -> {
                        double salaryB = Double.parseDouble(b[3]);
                        double salaryA = Double.parseDouble(a[3]);
                        return Double.compare(salaryB, salaryA);
                    })
                    .limit(5)
                    .toList();

            System.out.println("Top 5 highest-paid employees:");
            for (String[] emp : sorted) {
                System.out.println("Name: " + emp[1]);
                System.out.println("Department: " + emp[2]);
                System.out.println("Salary: " + emp[3]);
                System.out.println("-------------------");
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
