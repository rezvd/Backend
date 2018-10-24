package summatra.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleSummaterTest {
    private IArraySummater summater;

    @Before
    public void setUp() {
        summater = new SimpleSummater();
    }

    @Test
    public void testSum() throws ArraySummaterException {
        int[] array = {1, 2, 3, 0, -10};
        int sum = summater.sum(array);
        assertEquals("wrong sum", -4, sum);
    }

    @Test
    public void testOneElement() throws ArraySummaterException {
        int[] array = {-6};
        int sum = summater.sum(array);
        assertEquals("wrong sum", -6, sum);
    }

    @Test
    public void testForZero() throws ArraySummaterException {
        int[] array = {1, 2, 3, 0, -6};
        int sum = summater.sum(array);
        assertEquals("wrong sum", 0, sum);
    }

    @Test (expected = ArraySummaterException.class)
    public void testEmpyArray() throws ArraySummaterException {
        int[] array = {};
        int sum = summater.sum(array);
    }
}
