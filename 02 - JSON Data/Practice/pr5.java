package Day24.Practice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class pr5 {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Alice\", \"age\": 25 }"; // Try invalid JSON to test

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree(json);
            System.out.println("Valid JSON structure.");
        } catch (JsonProcessingException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
