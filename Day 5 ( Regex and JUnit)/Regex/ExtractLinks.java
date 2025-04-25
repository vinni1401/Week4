import java.util.Scanner;
import java.util.regex.*;

public class ExtractLinks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text with URLs:");
        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("https?://\\S+").matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
