package Day25.Annotations.Beginner;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectModule {
    @Todo(task = "Implement login", assignedTo = "John", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature...");
    }

    @Todo(task = "Add logging", assignedTo = "Emma")
    public void loggingFeature() {
        System.out.println("Logging feature...");
    }

    public void completedFeature() {
        System.out.println("This feature is done.");
    }
}

public class pr2 {
    public static void main(String[] args) {
        Method[] methods = ProjectModule.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}

