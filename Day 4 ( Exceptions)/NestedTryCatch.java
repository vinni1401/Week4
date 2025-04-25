import java.util.*;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter array size: ");
            int size = sc.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            try {
                System.out.print("Enter index: ");
                int index = sc.nextInt();
                System.out.print("Enter divisor: ");
                int divisor = sc.nextInt();
                int result = arr[index] / divisor;
                System.out.println("Result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }
    }
}
