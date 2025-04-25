import java.util.*;
import java.util.stream.*;

public class FilterStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Avocado", "Mango", "Apricot");
        list.stream()
            .filter(s -> !s.startsWith("A"))
            .forEach(System.out::println);
    }
}