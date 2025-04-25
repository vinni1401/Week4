import java.util.*;
import java.io.*;

public class WordFrequency {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(path));
        HashMap<String, Integer> map = new HashMap<>();
        String line;

        while ((line = br.readLine()) != null) {
            line = line.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (!words[i].isEmpty()) {
                    map.put(words[i], map.getOrDefault(words[i], 0) + 1);
                }
            }
        }
        br.close();
        System.out.println("Word Frequency: " + map);
    }
}
