package Day23.Advanced;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class pr3 {

    public static void main(String[] args) {
        String file1 = "D:\\Capgemini\\Java\\src\\Day23\\Advanced\\students1.csv";
        String file2 = "D:\\Capgemini\\Java\\src\\Day23\\Advanced\\students2.csv";
        String outputFile = "merged_students.csv";

        try {
            Map<String, String[]> studentInfoMap = Files.readAllLines(Paths.get(file1))
                    .stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .collect(Collectors.toMap(
                            fields -> fields[0],
                            fields -> new String[]{fields[1], fields[2]}
                    ));

            List<String> mergedLines = new ArrayList<>();
            mergedLines.add("ID,Name,Age,Marks,Grade");

            Files.readAllLines(Paths.get(file2))
                    .stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .forEach(fields -> {
                        String id = fields[0];
                        String marks = fields[1];
                        String grade = fields[2];

                        if (studentInfoMap.containsKey(id)) {
                            String[] info = studentInfoMap.get(id);
                            String merged = id + "," + info[0] + "," + info[1] + "," + marks + "," + grade;
                            mergedLines.add(merged);
                        }
                    });

            Files.write(Paths.get(outputFile), mergedLines);
            System.out.println(" Merged CSV created: " + outputFile);

        } catch (IOException e) {
            System.err.println(" Error processing files: " + e.getMessage());
        }
    }
}

