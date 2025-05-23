package Day23.Basic;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountStudentRecords {
    public static void main(String[] args) {
        String fileName = "D:\\Capgemini\\Java\\src\\Day23\\Basic\\Students.csv";

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            long recordCount = lines.stream().skip(1).count();

            System.out.println("Total number of records (excluding header): " + recordCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

