import java.util.Scanner;
import java.util.regex.*;

public class ExtractDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text with dates:");
        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
