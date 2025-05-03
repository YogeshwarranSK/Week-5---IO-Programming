package Day25.Reflection.Intermediate_level;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
public class pr6 {
    public static void main(String[] args) {
        Class<pr6> clazz = pr6.class;

        if (clazz.isAnnotationPresent(Author.class)) {
            Author authorAnnotation = clazz.getAnnotation(Author.class);
            System.out.println("Author Name: " + authorAnnotation.name());
        } else {
            System.out.println("No @Author annotation present.");
        }
    }
}

