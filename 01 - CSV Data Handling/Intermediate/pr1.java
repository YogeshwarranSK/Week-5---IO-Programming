package Day23.Intermediate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class pr1 {
    public static void main(String[] args) {
        String fileName = "D:\\Capgemini\\Java\\src\\Day23\\Intermediate\\students.csv";

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            System.out.println("Students scoring more than 80 marks:");
            lines.stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(fields -> {
                        try {
                            int marks = Integer.parseInt(fields[3]);
                            return marks >= 80;
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            return false;
                        }
                    })
                    .forEach(fields -> {
                        System.out.println("ID: " + fields[0]);
                        System.out.println("Name: " + fields[1]);
                        System.out.println("Age: " + fields[2]);
                        System.out.println("Marks: " + fields[3]);
                        System.out.println("-------------------");
                    });

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

