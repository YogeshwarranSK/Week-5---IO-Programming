package Day23.Intermediate;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class ITSalaryUpdater {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));

            List<String> updatedLines = lines.stream()
                    .map(line -> {
                        if (line.startsWith("ID")) return line; // header
                        String[] fields = line.split(",");
                        if (fields[2].equalsIgnoreCase("IT")) {
                            double salary = Double.parseDouble(fields[3]);
                            salary *= 1.10; // increase by 10%
                            fields[3] = String.format("%.2f", salary); // format to 2 decimals
                        }
                        return String.join(",", fields);
                    })
                    .collect(Collectors.toList());

            Files.write(Paths.get(outputFile), updatedLines);
            System.out.println("Updated salaries saved to: " + outputFile);

        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
