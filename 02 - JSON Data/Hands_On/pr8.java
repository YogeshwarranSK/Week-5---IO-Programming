package Day24.Hands_On;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.*;

public class pr8 {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "admin";


        String query = "SELECT id, name, age, email FROM users";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<Map<String, Object>> usersList = new ArrayList<>();

        while (rs.next()) {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("id", rs.getInt("id"));
            userMap.put("name", rs.getString("name"));
            userMap.put("age", rs.getInt("age"));
            userMap.put("email", rs.getString("email"));
            usersList.add(userMap);
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(usersList);

        System.out.println(json);

        rs.close();
        stmt.close();
        conn.close();
    }
}
