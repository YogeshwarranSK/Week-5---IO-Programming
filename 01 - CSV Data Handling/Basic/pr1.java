package Day23.Basic;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class pr1 {
    public static void main(String[] args) {
        String fileName = "D:\\Capgemini\\Java\\src\\Day23\\Basic\\Students.csv";

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            lines.stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .forEach(fields -> {
                        System.out.println("ID: " + fields[0]);
                        System.out.println("Name: " + fields[1]);
                        System.out.println("Age: " + fields[2]);
                        System.out.println("Marks: " + fields[3]);
                        System.out.println("-------------------");
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

