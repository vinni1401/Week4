import java.util.*;

public class BinaryNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        System.out.println("Binary Numbers:");
        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            System.out.print(current + " ");
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}
