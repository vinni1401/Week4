import java.util.*;

interface Category {}

class BookCategory implements Category {}
class ClothingCategory implements Category {}
class GadgetCategory implements Category {}

class Product<T extends Category> {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String toString() { return name + ": $" + price; }
}

public class OnlineMarketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product<BookCategory> book = new Product<>("Java Book", 500);
        Product<ClothingCategory> shirt = new Product<>("Shirt", 1000);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000);

        System.out.print("Enter discount for book: ");
        applyDiscount(book, sc.nextDouble());
        System.out.print("Enter discount for shirt: ");
        applyDiscount(shirt, sc.nextDouble());
        System.out.print("Enter discount for gadget: ");
        applyDiscount(phone, sc.nextDouble());

        System.out.println("\nDiscounted Products:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}
