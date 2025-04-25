import org.example.FileProcessor;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    FileProcessor processor = new FileProcessor();

    @Test
    void testWriteAndReadFile() throws IOException {
        String filename = "testfile.txt";
        String content = "Hello World";

        processor.writeToFile(filename, content);
        assertTrue(new File(filename).exists());

        String readContent = processor.readFromFile(filename);
        assertEquals(content, readContent);
    }

    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("nonexistent.txt");
        });
    }
}
