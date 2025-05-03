package Day25.Annotations.Advanced;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
     String username;

    @JsonField(name = "user_email")
     String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                json.append("\"")
                        .append(annotation.name())
                        .append("\": \"")
                        .append(field.get(obj))
                        .append("\", ");
            }
        }

        if (json.lastIndexOf(", ") == json.length() - 2) {
            json.delete(json.length() - 2, json.length());
        }

        json.append("}");
        return json.toString();
    }
}

public class pr6 {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("john_doe", "john@example.com");
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
