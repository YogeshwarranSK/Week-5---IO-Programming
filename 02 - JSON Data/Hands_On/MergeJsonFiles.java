package Day24.Hands_On;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode node1 = mapper.readTree(new File("file1.json"));
        JsonNode node2 = mapper.readTree(new File("file2.json"));

        ObjectNode merged = ((ObjectNode) node1).setAll((ObjectNode) node2);

        String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(merged);
        System.out.println(result);
    }
}
