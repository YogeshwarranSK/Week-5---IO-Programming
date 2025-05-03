package Day23.Advanced;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import java.io.*;
import java.util.*;

class Student {
    private String id;
    private String name;
    private String grade;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

public class JsonCsvConverter {
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Student> students = mapper.readValue(new File(jsonFile), new TypeReference<List<Student>>(){});
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                writer.writeNext(new String[]{"id", "name", "grade"});
                for (Student s : students) {
                    writer.writeNext(new String[]{s.getId(), s.getName(), s.getGrade()});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<Student> students = new ArrayList<>();
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                Student s = new Student();
                s.setId(line[0]);
                s.setName(line[1]);
                s.setGrade(line[2]);
                students.add(s);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(jsonFile), students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jsonToCsv("students.json", "students.csv");
        csvToJson("students.csv", "students_converted.json");
    }
}
