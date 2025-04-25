// ListManagerTest.java
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {
    ListManager lm = new ListManager();

    @Test void testAdd() {
        List<Integer> list = new ArrayList<>();
        lm.addElement(list, 10);
        assertEquals(1, lm.getSize(list));
    }

    @Test void testRemove() {
        List<Integer> list = new ArrayList<>();
        list.add(5); lm.removeElement(list, 5);
        assertFalse(list.contains(5));
    }

    @Test void testSize() {
        List<Integer> list = new ArrayList<>();
        lm.addElement(list, 2); lm.addElement(list, 4);
        assertEquals(2, lm.getSize(list));
    }
}
