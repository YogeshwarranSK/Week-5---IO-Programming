package Day25.Annotations.Intermediate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
     String username;

    public User(String username) {
        this.username = username;
        validateLength();
    }

    private void validateLength() {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username != null && username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

public class pr4 {
    public static void main(String[] args) {
        new User("shortName");
        new User("thisUsernameIsTooLong");
    }
}

