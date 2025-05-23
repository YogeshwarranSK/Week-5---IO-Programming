package Day24.Practice;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterStudentsByAge {
    public static void main(String[] args) throws Exception {
        String json = """
        [
          { "name": "Sai", "age": 22 },
          { "name": "Aswin", "age": 22 },
          { "name": "Sagar", "age": 21 }
        ]
        """;

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode array = (ArrayNode) mapper.readTree(json);

        for (JsonNode node : array) {
            if (node.get("age").asInt() > 21) {
                System.out.println(node);
            }
        }
    }
}
