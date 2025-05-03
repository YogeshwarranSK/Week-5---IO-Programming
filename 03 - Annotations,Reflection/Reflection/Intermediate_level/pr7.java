package Day25.Reflection.Intermediate_level;
import java.lang.reflect.Field;

public class pr7 {
    private static String API_KEY = "initial_api_key";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Configuration> clazz = Configuration.class;
        Field apiKeyField = clazz.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);

        System.out.println("Before modification: " + API_KEY);

        apiKeyField.set(null, "new_api_key");

        System.out.println("After modification: " + API_KEY);
    }
}
