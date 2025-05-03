package Day24.Hands_On;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class pr7 {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("data.csv"));
        List<String[]> rows = reader.readAll();

        List<Map<String, String>> jsonList = new ArrayList<>();
        String[] header = rows.get(0);

        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            Map<String, String> map = new LinkedHashMap<>();
            for (int j = 0; j < row.length; j++) {
                map.put(header[j], row[j]);
            }
            jsonList.add(map);
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonList);
        System.out.println(json);
    }
}

