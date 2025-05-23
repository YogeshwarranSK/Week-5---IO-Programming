package Day24.Hands_On;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXmlConverter {
    public static void main(String[] args) throws Exception {
        String json = """
        {
          "name": "ABC",
          "age": 25,
          "email": "ABC@example.com"
        }
        """;

        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode tree = jsonMapper.readTree(json);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree);

        System.out.println(xml);
    }
}

