import java.util.Scanner;

public class CensorBadWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] badWords = {"damn", "stupid"};
        System.out.println("Enter sentence:");
        String input = sc.nextLine();
        for (int i = 0; i < badWords.length; i++) {
            input = input.replaceAll("(?i)\\b" + badWords[i] + "\\b", "****");
        }
        System.out.println(input);
    }
}
