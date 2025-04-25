import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        System.out.println("Enter N (from end):");
        int k = sc.nextInt();

        int fast = 0, slow = 0;
        while (fast < k) {
            fast++;
            if (fast >= list.size()) {
                System.out.println("Invalid input");
                return;
            }
        }
        while (fast < list.size() - 1) {
            slow++;
            fast++;
        }

        System.out.println(list.get(slow));
    }
}
