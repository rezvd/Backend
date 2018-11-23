package com.sevenbits.file_list.task1.output;

import java.io.IOException;

public interface CharWriter {

    void write(int i) throws IOException;

    void writeLine(String s) throws IOException;
}
