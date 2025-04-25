import java.util.Scanner;
import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE).matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
