package com.sevenbits.file_list.task1.output;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedByteWriter implements ByteWriter, Closeable {
    private BufferedOutputStream outputStream;

    public BufferedByteWriter(final OutputStream out) {
        outputStream = new BufferedOutputStream(out);
    }

    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    public void close() throws IOException {
        outputStream.close();
    }
}
