import java.util.Scanner;
import java.util.regex.*;

public class ExtractCurrencyValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text with currency values:");
        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
