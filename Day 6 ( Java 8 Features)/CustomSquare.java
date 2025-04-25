@FunctionalInterface
interface Square {
    int calculate(int x);

    default void display(int x) {
        System.out.println("Square of " + x + " is " + calculate(x));
    }
}

public class CustomSquare {
    public static void main(String[] args) {
        Square square = n -> n * n;
        square.display(6);
    }
}
