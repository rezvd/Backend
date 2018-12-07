package it.sevenbits.courses.sm.network;

public class NetworkPackage {
    private String type;

    private String message;

    public NetworkPackage(final String type, final String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
