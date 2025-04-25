public class SumOfSquares {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = nums.stream()
                         .filter(n -> n % 2 == 0)
                         .map(n -> n * n)
                         .reduce(0, Integer::sum);
        System.out.println("Sum of squares of even numbers: " + result);
    }
}