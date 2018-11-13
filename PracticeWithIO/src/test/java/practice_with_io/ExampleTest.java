package practice_with_io;

import com.sevenbits.practice_with_io.Example;
import com.sevenbits.practice_with_io.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExampleTest {
    private FileReader reader = mock(FileReader.class);

    @Before
    public void setUp() throws IOException {
        when(reader.readLine()).thenReturn("123", "1234567", "1", "12345");
        when(reader.hasMoreLines()).thenReturn(true, true, true, true, false);
    }

    @Test
    public void test() throws IOException {
        Example example = new Example();
        assertEquals(7, example.getLongestLineCharCount(reader));
    }
}
