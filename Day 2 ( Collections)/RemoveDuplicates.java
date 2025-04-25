import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        List<Integer> input = new ArrayList<>();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            input.add(sc.nextInt());
        }

        Set<Integer> seen = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            int val = input.get(i);
            if (!seen.contains(val)) {
                seen.add(val);
                output.add(val);
            }
        }
        System.out.println(output);
    }
}
