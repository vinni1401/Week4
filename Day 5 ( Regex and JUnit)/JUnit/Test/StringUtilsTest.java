// StringUtilsTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    StringUtils su = new StringUtils();

    @Test void testReverse() { assertEquals("cba", su.reverse("abc")); }
    @Test void testPalindrome() {
        assertTrue(su.isPalindrome("Madam"));
        assertFalse(su.isPalindrome("Hello"));
    }
    @Test void testUpperCase() { assertEquals("JAVA", su.toUpperCase("java")); }
}
