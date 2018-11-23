package com.sevenbits.file_list.task1.input;

import java.io.IOException;

public interface ByteReader {

    int read() throws IOException;

    boolean hasNext() throws IOException;
}
