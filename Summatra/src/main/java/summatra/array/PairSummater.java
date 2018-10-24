package summatra.array;

/**
 * Addselemens of and summatra.array by pairs
 */
public class PairSummater implements IArraySummater {

    /**
     * Adds elements of an summatra.array by pairs
     * @param array An summatra.array, which elements will be added
     * @return biggest sum of the pairs
     * @throws ArraySummaterException if the summatra.array length is not a multiply by two or an summatra.array is empty
     */
    public int sum(final int[] array) throws ArraySummaterException {
        if (array.length % 2 != 0) {
            throw new ArraySummaterException("The summatra.array length is not a multiply by two");
        } else if (array.length == 0) {
            throw new ArraySummaterException("The summatra.array is empty");
        } else {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < array.length; i += 2) {
                if (array[i] + array[i + 1] > max) {
                    max = array[i] + array[i + 1];
                }
            }
            return max;
        }
    }
}
