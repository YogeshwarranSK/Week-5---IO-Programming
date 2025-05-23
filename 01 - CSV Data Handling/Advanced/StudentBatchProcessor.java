package Day23.Advanced;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentBatchProcessor {
    public static void main(String[] args) {
        String fileName = "D:\\Capgemini\\Java\\src\\Day23\\Advanced\\students.csv";
        int batchSize = 100;
        int totalCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<String> batch = new ArrayList<>();

            String header = br.readLine();

            while ((line = br.readLine()) != null) {
                batch.add(line);
                if (batch.size() == batchSize) {
                    processBatch(batch);
                    totalCount += batch.size();
                    System.out.println(" Records processed so far: " + totalCount);
                    batch.clear();
                }
            }

            if (!batch.isEmpty()) {
                processBatch(batch);
                totalCount += batch.size();
                System.out.println("  Records processed so far: " + totalCount);
            }

            System.out.println(" Finished processing " + totalCount + " records.");

        } catch (IOException e) {
            System.err.println("  Error reading the file: " + e.getMessage());
        }
    }

    private static void processBatch(List<String> batch) {

        for (String record : batch) {
            String[] fields = record.split(",");
            System.out.println("ID: " + fields[0]);
        }
    }
}

