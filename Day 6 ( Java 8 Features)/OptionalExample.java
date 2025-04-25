import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList();

        Optional<Integer> max = nums.stream().max(Integer::compare);

        max.ifPresentOrElse(
            value -> System.out.println("Max value: " + value),
            () -> System.out.println("List is empty")
        );
    }
}
