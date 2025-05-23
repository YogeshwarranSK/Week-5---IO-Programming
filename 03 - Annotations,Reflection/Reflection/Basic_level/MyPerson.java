package Day25.Reflection.Basic_level;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MyPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("\nMethods:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method);
            }

            System.out.println("\nFields:");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println(field);
            }

            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println(constructor);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}

