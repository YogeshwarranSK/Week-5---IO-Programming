package Day24.Practice;
import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJsonBuilder {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Alice");
        student.put("age", 20);

        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Physics");
        subjects.put("Computer Science");

        student.put("subjects", subjects);

        System.out.println(student.toString(2));
    }
}

