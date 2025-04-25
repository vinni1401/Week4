import java.util.Scanner;

public class ValidateCreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String card = sc.nextLine();
        if (card.matches("^4\\d{15}$")) {
            System.out.println("Valid Visa Card");
        } else if (card.matches("^5\\d{15}$")) {
            System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid Card");
        }
    }
}
