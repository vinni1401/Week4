import java.util.function.Predicate;

public class PredicateFilter {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("example", "test", "Java", "advanced", "alphabet");
        Predicate<String> longerThan5 = s -> s.length() > 5;
        Predicate<String> containsA = s -> s.contains("a");

        strings.stream()
               .filter(longerThan5.and(containsA))
               .forEach(System.out::println);
    }
}
