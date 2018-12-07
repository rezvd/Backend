package it.sevenbits.courses.sm.log;

import java.util.HashMap;
import java.util.Map;

public class MessageFormatter {
    private Map<String, String> formatter;

    public MessageFormatter() {
        formatter = new HashMap<>();
        formatter.put("MESSAGE", "Part of message: %1$s");
        formatter.put("TRASH", "Trash received");
        formatter.put("MESSAGE_START", "Message creating started");
        formatter.put("MESSAGE_FINISH", "Message creating finished");
    }

    public String getStringFormatByType(final String type) {
        return formatter.getOrDefault(type, "Unknown");
    }
}
