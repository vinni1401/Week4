import java.util.Scanner;

public class ValidateIPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IPv4 address: ");
        String ip = sc.nextLine();
        String pattern = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
                       + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        if (ip.matches(pattern)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
