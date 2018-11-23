package com.sevenbits.file_list.task1.output;


import java.io.*;
import java.nio.charset.Charset;

public class BufferedCharWriter implements CharWriter, Closeable {
    private BufferedWriter bw;

    public BufferedCharWriter(final Writer writer){
        bw = new BufferedWriter(writer);
    }


    public BufferedCharWriter(final OutputStream out, final Charset charset){
        bw = new BufferedWriter(new OutputStreamWriter(out, charset));
    }

    @Override
    public void write(int i) throws IOException {
        bw.write(i);
    }

    @Override
    public void writeLine(String s) throws IOException {
        bw.write(s);
    }

    @Override
    public void close() throws IOException {
        bw.close();
    }
}
