package Day25.Annotations.Advanced;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class AccessControl {
    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task performed.");
    }
}

public class pr5 {
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; // change to "ADMIN" to allow access

        AccessControl obj = new AccessControl();
        Method method = AccessControl.class.getMethod("performAdminTask");

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (roleAllowed.value().equals(currentUserRole)) {
                method.invoke(obj);
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}

