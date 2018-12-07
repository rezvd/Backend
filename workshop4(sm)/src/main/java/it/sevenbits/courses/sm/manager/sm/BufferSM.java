package it.sevenbits.courses.sm.manager.sm;

public class BufferSM {
    private StringBuilder buffer;

    public BufferSM() {
        buffer = new StringBuilder();
    }

    public void write(String string) {
        buffer.append(string);
    }

    public void clear() {
        buffer.delete(0, buffer.length());
    }

    @Override
    public String toString() {
        return  buffer.toString();
    }
}
