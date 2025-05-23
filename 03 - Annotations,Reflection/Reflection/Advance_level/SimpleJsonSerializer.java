package Day25.Reflection.Advance_level;
import java.lang.reflect.Field;

public class SimpleJsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder json = new StringBuilder();
        json.append("{");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(obj);

            json.append("\"").append(name).append("\":");

            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }

            if (i < fields.length - 1) {
                json.append(",");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("alice", 28, true);
        String json = toJson(user);
        System.out.println(json);
    }
}

class User {
     String username;
     int age;
     boolean active;

    public User(String username, int age, boolean active) {
        this.username = username;
        this.age = age;
        this.active = active;
    }
}

