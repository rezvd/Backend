package practice_with_io;

import com.sevenbits.practice_with_io.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileReaderTest {

    private FileReader reader;

    @Before
    public void setUp() throws IOException {
        reader = new FileReader("Test.txt");
    }

    @Test
    public void test() throws IOException {
        assertTrue(reader.hasMoreLines());
        assertEquals("111\n", reader.readLine());
        assertTrue(reader.hasMoreLines());
        assertEquals("2 This is second line\n", reader.readLine());
        assertTrue(reader.hasMoreLines());
        assertEquals("\n", reader.readLine());
        assertTrue(reader.hasMoreLines());
        assertEquals("3 Third line in this boring text\n", reader.readLine());
        assertTrue(reader.hasMoreLines());
        assertEquals("4 Unexpectedly, it's a fourth string\n", reader.readLine());
        assertTrue(reader.hasMoreLines());
        assertEquals("5 Finally, last (fifth) line\n", reader.readLine());
        assertFalse(reader.hasMoreLines());
    }
}