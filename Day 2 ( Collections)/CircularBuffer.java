import java.util.*;

public class CircularBuffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Buffer size: ");
        int size = sc.nextInt();
        int[] buffer = new int[size];
        int index = 0;

        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            buffer[index] = val;
            index = (index + 1) % size;
        }

        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(index + i) % size] + " ");
        }
    }
}
