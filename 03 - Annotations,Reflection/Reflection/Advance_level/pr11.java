package Day25.Reflection.Advance_level;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

interface Service {
    void serve();
}

class ServiceImpl implements Service {
    public void serve() {
        System.out.println("Service is serving.");
    }
}

class Client {
    @Inject
    private Service service;

    public void doSomething() {
        service.serve();
    }
}

class SimpleDIContainer {
    private static final Map<Class<?>, Class<?>> bindings = new HashMap<>();

    static {
        bindings.put(Service.class, ServiceImpl.class);  // Bind interface to implementation
    }

    public static <T> T createInstance(Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Class<?> implClass = bindings.get(fieldType);
                if (implClass == null) {
                    throw new RuntimeException("No implementation bound for " + fieldType.getName());
                }
                Object dependency = implClass.getDeclaredConstructor().newInstance();
                field.setAccessible(true);
                field.set(instance, dependency);
            }
        }

        return instance;
    }
}

public class pr11 {
    public static void main(String[] args) throws Exception {
        Client client = SimpleDIContainer.createInstance(Client.class);
        client.doSomething();
    }
}
