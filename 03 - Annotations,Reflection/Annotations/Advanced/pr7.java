package Day25.Annotations.Advanced;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

class ExpensiveComputation {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int x) {
        if (cache.containsKey(x)) {
            System.out.println("Returning cached result for: " + x);
            return cache.get(x);
        }
        System.out.println("Computing result for: " + x);
        int result = x * x;
        cache.put(x, result);
        return result;
    }
}

public class pr7 {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation obj = new ExpensiveComputation();
        Method method = ExpensiveComputation.class.getMethod("computeSquare", int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println("Result: " + obj.computeSquare(5));
            System.out.println("Result: " + obj.computeSquare(5));
            System.out.println("Result: " + obj.computeSquare(10));
            System.out.println("Result: " + obj.computeSquare(10));
        }
    }
}
