package it.sevenbits.courses.sm.manager;

public class NetworkManagerException extends Exception {

    public NetworkManagerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NetworkManagerException(final String message) {
        super(message);
    }
}
