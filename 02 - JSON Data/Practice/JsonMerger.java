package Day24.Practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonMerger {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json1 = "{\"name\":\"Yogesh\",\"age\":22}";
        String json2 = "{\"email\":\"yogesh@gmail.com\",\"dob\":11072003}";

        ObjectNode node1 = (ObjectNode) mapper.readTree(json1);
        ObjectNode node2 = (ObjectNode) mapper.readTree(json2);

        node1.setAll(node2);

        String mergedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node1);
        System.out.println(mergedJson);
    }
}
