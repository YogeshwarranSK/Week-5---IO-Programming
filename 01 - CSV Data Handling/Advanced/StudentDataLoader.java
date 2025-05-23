package Day23.Advanced;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentDataLoader {

    static class Student {
         int id;
         String name;
         int age;
         int marks;

        public Student(int id, String name, int age, int marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Marks=" + marks + "]";
        }
    }

    public static void main(String[] args) {
        String fileName = "D:\\Capgemini\\Java\\src\\Day23\\Advanced\\students.csv";
        List<Student> studentList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            lines.stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .forEach(fields -> {
                        int id = Integer.parseInt(fields[0]);
                        String name = fields[1];
                        int age = Integer.parseInt(fields[2]);
                        int marks = Integer.parseInt(fields[3]);

                        Student student = new Student(id, name, age, marks);
                        studentList.add(student);
                    });

            studentList.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println(" Error reading the file: " + e.getMessage());
        }
    }
}
