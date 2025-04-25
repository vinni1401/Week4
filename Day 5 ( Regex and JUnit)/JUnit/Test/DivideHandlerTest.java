// DivideHandlerTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivideHandlerTest {
    DivideHandler dh = new DivideHandler();

    @Test void testDivide() { assertEquals(3, dh.divide(9, 3)); }
    @Test void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> dh.divide(5, 0));
    }
}
