package summatra.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PairSummaterTest {

    private IArraySummater summater;

    @Before
    public void setUp() {
        summater = new PairSummater();
    }

    @Test
    public void testSum() throws ArraySummaterException {
        int[] array = {1, 2, 3, 0, -6, 10};
        int sum = summater.sum(array);
        assertEquals("wrong sum", 4, sum);
    }

    @Test
    public void testWithEqualSum() throws ArraySummaterException {
        int[] array = {1, 2, 3, 0, -6, 1};
        int sum = summater.sum(array);
        assertEquals("wrong sum", 3, sum);
    }

    @Test
    public void testWithOneSum() throws ArraySummaterException {
        int[] array = {-6, 1};
        int sum = summater.sum(array);
        assertEquals("wrong sum", -5, sum);
    }

    @Test (expected = ArraySummaterException.class)
    public void testEmptyArray() throws ArraySummaterException {
        int[] array = {};
        int sum = summater.sum(array);
    }


    @Test (expected = ArraySummaterException.class)
    public void testWithException() throws ArraySummaterException {
        int[] array = {1, 2, 3, 0, -6};
        int sum = summater.sum(array);
    }

}
