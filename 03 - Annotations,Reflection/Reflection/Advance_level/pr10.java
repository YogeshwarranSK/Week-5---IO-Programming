package Day25.Reflection.Advance_level;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class pr10 {

    interface Greeting {
        void sayHello();
        void sayGoodbye();
    }

    static class GreetingImpl implements Greeting {
        public void sayHello() {
            System.out.println("Hello!");
        }

        public void sayGoodbye() {
            System.out.println("Goodbye!");
        }
    }

    static class LoggingHandler implements InvocationHandler {
        private final Object target;

        public LoggingHandler(Object target) {
            this.target = target;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Invoked method: " + method.getName());
            return method.invoke(target, args);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T createLoggingProxy(Class<T> interfaceType, T implementation) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new LoggingHandler(implementation)
        );
    }

    public static void main(String[] args) {
        Greeting greeting = createLoggingProxy(Greeting.class, new GreetingImpl());
        greeting.sayHello();
        greeting.sayGoodbye();
    }
}
