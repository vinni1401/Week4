import org.example.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password1"));
    }

    @Test
    void testInvalidPassword() {
        assertFalse(validator.isValid("pass"));
        assertFalse(validator.isValid("password"));
        assertFalse(validator.isValid("PASSWORD"));
    }
}
