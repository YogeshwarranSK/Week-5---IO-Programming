package Day24.Practice;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class pr3 {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("user.json"));

        String name = root.get("name").asText();
        String email = root.get("email").asText();

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
