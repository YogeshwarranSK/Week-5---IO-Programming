package Day25.Reflection.Advance_level;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ReflectionObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties)
            throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(instance, entry.getValue());
        }

        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> data = Map.of(
                "id", 101,
                "name", "Laptop",
                "price", 799.99
        );

        Product product = toObject(Product.class, data);
        System.out.println("ID: " + product.id);
        System.out.println("Name: " + product.name);
        System.out.println("Price: " + product.price);
    }
}

class Product {
    public int id;
    public String name;
    public double price;
}

