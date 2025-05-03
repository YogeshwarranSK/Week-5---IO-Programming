package Day25.Reflection.Basic_level;
import java.lang.reflect.Field;

class Person {
     int age = 25;
}

public class pr2 {
    public static void main(String[] args) throws Exception {
        Person person = new Person();

        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println("Original age: " + field.get(person));

        field.set(person, 40);
        System.out.println("Modified age: " + field.get(person));
    }
}

