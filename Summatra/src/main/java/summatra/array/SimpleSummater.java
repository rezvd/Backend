package summatra.array;

/**
 * Adds all elements of an summatra.array
 */
public class SimpleSummater implements IArraySummater {

    /**
     * Adds all elements of an summatra.array
     * @param array An summatra.array, which elements will be added
     * @return sum of all elements of an summatra.array
     * @throws ArraySummaterException is summatra.array is empty
     */
    public int sum(final int[] array) throws ArraySummaterException {
        if (array.length == 0) {
            throw new ArraySummaterException("Array is empty");
        } else {
            int sum = 0;
            for (int item: array) {
                sum += item;
            }
            return sum;
        }
    }
}
