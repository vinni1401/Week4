import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("hello", "world", "java");
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());

        items.forEach(printUpper);
    }
}