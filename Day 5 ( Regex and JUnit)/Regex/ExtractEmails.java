import java.util.Scanner;
import java.util.regex.*;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String input = sc.nextLine();
        Matcher matcher = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
