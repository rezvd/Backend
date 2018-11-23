package com.sevenbits.file_list.task1.input;

import java.io.IOException;

public interface CharReader {

    int read() throws IOException;

    String readLine() throws IOException;

    boolean hasNext() throws IOException;
}
