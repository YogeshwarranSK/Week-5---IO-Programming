package Day23.Basic;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class pr2 {
    public static void main(String[] args) {
        String fileName = "employees.csv";

        List<String[]> employees = Arrays.asList(
                new String[]{"ID", "Name", "Department", "Salary"},
                new String[]{"1", "Alice", "HR", "55000"},
                new String[]{"2", "Bob", "IT", "65000"},
                new String[]{"3", "Charlie", "Finance", "60000"},
                new String[]{"4", "Diana", "Marketing", "52000"},
                new String[]{"5", "Ethan", "IT", "70000"}
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String[] emp : employees) {
                writer.write(String.join(",", emp));
                writer.newLine();
            }
            System.out.println("Data written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
