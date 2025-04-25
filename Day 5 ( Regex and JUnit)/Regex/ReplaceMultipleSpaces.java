import java.util.Scanner;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text with multiple spaces:");
        String input = sc.nextLine();
        String result = input.replaceAll("\\s{2,}", " ");
        System.out.println(result);
    }
}
