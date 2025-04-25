import org.example.DateFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDateFormatting() throws ParseException {
        assertEquals("09-05-2025", formatter.formatDate("2025-05-09"));
        assertEquals("25-12-2024", formatter.formatDate("2024-12-25"));
    }

    @Test
    void testInvalidDate() {
        assertThrows(ParseException.class, () -> {
            formatter.formatDate("invalid-date");
        });
    }
}
