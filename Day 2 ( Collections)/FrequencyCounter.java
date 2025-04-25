import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of strings:");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        System.out.println(freq);
    }
}
