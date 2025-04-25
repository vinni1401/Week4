import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        System.out.print("Enter number of entries: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            map.put(key, value);
        }

        HashMap<Integer, List<String>> inverted = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (!inverted.containsKey(val)) {
                inverted.put(val, new ArrayList<>());
            }
            inverted.get(val).add(entry.getKey());
        }

        System.out.println("Inverted Map: " + inverted);
    }
}
