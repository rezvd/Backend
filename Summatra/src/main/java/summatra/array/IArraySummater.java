package summatra.array;

/**
 * Interface, that cun add arrays
 */

public interface IArraySummater {

    /**
     * Doing the summation in the way, detailed in the class.
     * @param array An summatra.array, which elements will be added
     * @return the sem of the summatra.array
     * @throws ArraySummaterException if the error is appear while adding
     */
    int sum(int[] array) throws ArraySummaterException;
}
