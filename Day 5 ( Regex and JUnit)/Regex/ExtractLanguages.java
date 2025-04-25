import java.util.Scanner;
import java.util.regex.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b", Pattern.CASE_INSENSITIVE).matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
