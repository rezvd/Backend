package com.sevenbits.file_list.task1.input;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class BufferedByteReader implements ByteReader, Closeable {
    private BufferedInputStream inputStream;

    public BufferedByteReader(final InputStream in) {
        inputStream = new BufferedInputStream(in);
    }

    public int read() throws IOException {
        return inputStream.read();
    }

    public boolean hasNext() throws IOException {
        return inputStream.available() > 0;
    }


    public void close() throws IOException {
        inputStream.close();
    }
}
