package Day25.Reflection.Intermediate_level;

import java.lang.reflect.Method;
import java.util.Scanner;

public class pr5 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MathOperations operations = new MathOperations();

        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.print("Enter first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        Object result = method.invoke(operations, a, b);

        System.out.println("Result: " + result);
    }
}


