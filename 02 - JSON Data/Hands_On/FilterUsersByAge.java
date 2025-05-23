package Day24.Hands_On;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterUsersByAge {
    public static void main(String[] args) throws Exception {
        String json = """
        [
          { "name": "A", "age": 23 },
          { "name": "B", "age": 27 },
          { "name": "C", "age": 30 }
        ]
        """;

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode users = (ArrayNode) mapper.readTree(json);

        for (JsonNode user : users) {
            if (user.get("age").asInt() > 25) {
                System.out.println(user);
            }
        }
    }
}
