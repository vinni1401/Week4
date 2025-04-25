import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        System.out.print("Enter entries for Map1: ");
        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            map1.put(key, value);
        }

        System.out.print("Enter entries for Map2: ");
        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
            System.out.print("Enter key: ");
            String key = sc.next();
            System.out.print("Enter value: ");
            int value = sc.nextInt();
            map2.put(key, value);
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            map1.put(key, map1.getOrDefault(key, 0) + value);
        }

        System.out.println("Merged Map: " + map1);
    }
}
