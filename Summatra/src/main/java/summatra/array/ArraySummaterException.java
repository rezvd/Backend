package summatra.array;

/**
 * Throws, if something go wrong in method "sum" in interface IArraySummater
 */

public class ArraySummaterException extends Exception {

    /**
     * Exception was thrown without any arguments
     */
    public ArraySummaterException() {
        super();
    }

    /**
     * Exception was thrown with massage about exception
     * @param message A message, which describes, what exactly happened
     */
    public ArraySummaterException(final String message) {
        super(message);
    }

    /**
     * Exception was thrown  with the specified cause of it
     * @param cause Cause, which describes, why this exception was thrown
     */

    public ArraySummaterException(final Throwable cause) {
        super(cause);
    }

    /**
     * Exception was thrown with message about exception and the specified cause
     * @param message  A message, which describes, what exactly happened
     * @param cause Cause, which describes, why this exception was thrown
     */
    public ArraySummaterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
