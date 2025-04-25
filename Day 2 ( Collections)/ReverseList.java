import java.util.*;

public class ReverseList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            arrayList.add(val);
            linkedList.add(val);
        }

        System.out.println("Reversed ArrayList:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arrayList.get(i) + " ");
        }

        System.out.println("\nReversed LinkedList:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(linkedList.get(i) + " ");
        }
    }
}
