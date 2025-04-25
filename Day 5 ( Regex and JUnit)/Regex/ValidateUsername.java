import java.util.Scanner;

public class ValidateUsername {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = sc.nextLine();
        if (username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
