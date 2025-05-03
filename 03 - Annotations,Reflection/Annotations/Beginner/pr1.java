package Day25.Annotations.Beginner;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class FeatureSet {
    @ImportantMethod
    public void coreLogic() {
        System.out.println("Executing core logic...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void helperFunction() {
        System.out.println("Executing helper function...");
    }

    public void unmarkedMethod() {
        System.out.println("This is a regular method.");
    }
}

public class pr1 {
    public static void main(String[] args) {
        Method[] methods = FeatureSet.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}
