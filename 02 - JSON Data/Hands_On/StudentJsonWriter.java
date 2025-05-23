package Day24.Hands_On;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class StudentJsonWriter {
    public static void main(String[] args) throws Exception {
        List<Student> students = Arrays.asList(
                new Student("Sagar", 20),
                new Student("Karthik", 22)
        );

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
        System.out.println(jsonArray);
    }
}
