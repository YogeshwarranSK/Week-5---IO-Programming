package Day25.Annotations.Intermediate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class PerformanceTest {
    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class pr3 {
    public static void main(String[] args) throws Exception {
        PerformanceTest obj = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (end - start) + " ns");
            }
        }
    }
}

