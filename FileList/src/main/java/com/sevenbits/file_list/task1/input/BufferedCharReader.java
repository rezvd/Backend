package com.sevenbits.file_list.task1.input;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class BufferedCharReader implements CharReader, Closeable {
    private BufferedReader br;

    public BufferedCharReader(final Reader reader) {
        br = new BufferedReader(reader);
    }


    public BufferedCharReader(final InputStream in, final Charset charset) {
        br = new BufferedReader(new InputStreamReader(in, charset));
    }

    @Override
    public int read() throws IOException {
        return br.read();
    }

    @Override
    public String readLine() throws IOException {
        return br.readLine();
    }

    @Override
    public boolean hasNext() throws IOException {
        return br.ready();
    }

    @Override
    public void close() throws IOException {
        br.close();
    }
}
