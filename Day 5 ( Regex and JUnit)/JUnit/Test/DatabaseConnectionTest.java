// DatabaseConnectionTest.java
import org.example.DatabaseConnection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.DatabaseConnection;

public class DatabaseConnectionTest {
    DatabaseConnection db;

    @BeforeEach void setup() {
        db = new DatabaseConnection();
        assertTrue(db.connect());
    }

    @AfterEach void teardown() {
        assertTrue(db.disconnect());
    }

    @Test void testConnectionWorks() {
        assertNotNull(db);
    }
}
