package Day23.Advanced;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class pr5 {
    public static void main(String[] args) {
        String fileName = "D:\\Capgemini\\Java\\src\\Day23\\Advanced\\duplicates.csv";

        Set<String> seenIds = new HashSet<>();
        Set<String> duplicateIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            System.out.println(" Duplicate Records:");
            lines.stream()
                    .skip(1)
                    .forEach(line -> {
                        String[] fields = line.split(",");
                        String id = fields[0];

                        if (!seenIds.add(id)) {
                            duplicateIds.add(id);
                            duplicateRecords.add(line);
                        }
                    });

            if (duplicateRecords.isEmpty()) {
                System.out.println(" No duplicate records found.");
            } else {
                lines.stream()
                        .skip(1)
                        .filter(line -> duplicateIds.contains(line.split(",")[0]))
                        .forEach(System.out::println);
            }

        } catch (IOException e) {
            System.err.println(" Error reading the file: " + e.getMessage());
        }
    }
}

