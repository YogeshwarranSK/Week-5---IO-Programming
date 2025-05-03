package Day25.Reflection.Advance_level;
import java.lang.reflect.Method;

public class pr12 {

    public static void measureExecutionTime(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
                method.setAccessible(true);
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                System.out.println("Executed " + method.getName() + " in " + (end - start) + " ns");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Sample sample = new Sample();
        measureExecutionTime(sample);
    }
}

class Sample {
    public void task1() {
        for (int i = 0; i < 1_000_000; i++) {}
    }

    public void task2() {
        try { Thread.sleep(100); } catch (InterruptedException ignored) {}
    }

    private void hiddenTask() {
        for (int i = 0; i < 500_000; i++) {}
    }
}

