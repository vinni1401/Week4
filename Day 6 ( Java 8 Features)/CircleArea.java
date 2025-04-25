import java.util.function.Function;

public class CircleArea {
    public static void main(String[] args) {
        Function<Double, Double> area = r -> Math.PI * r * r;
        System.out.println("Area of circle with radius 5: " + area.apply(5.0));
    }
}