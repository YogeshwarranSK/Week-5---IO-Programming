package Day25.Reflection.Basic_level;

import java.lang.reflect.Constructor;

class Student {
    String name;

    public Student() {
        this.name = "Default Student";
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class pr4 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Day25.Reflection.Basic_level.Student");
        Constructor<?> constructor = clazz.getConstructor();
        Object obj = constructor.newInstance();

        Student student = (Student) obj;
        student.display();
    }
}
