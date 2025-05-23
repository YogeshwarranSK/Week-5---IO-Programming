package Day25.Annotations;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    @BugReport(description = "Null pointer issue")
    @BugReport(description = "Performance bottleneck in loop")
    public void process() {
        System.out.println("Processing...");
    }
}

public class RepeatableAnnotationDemo {
    public static void main(String[] args) throws Exception {
        Method method = BugTracker.class.getMethod("process");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}

