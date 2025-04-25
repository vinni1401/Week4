import java.util.Scanner;
import java.util.regex.*;

public class ExtractCapitalizedWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence:");
        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
