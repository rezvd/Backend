package com.sevenbits.practice_with_io;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileReader {
    private Reader fileReader;

    public FileReader(String fileName) throws IOException {
        InputStream fileStream = new FileInputStream(new File(fileName));
        fileReader = new InputStreamReader(fileStream, "utf-8");
    }

    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        while (hasMoreLines() && (c = (char) fileReader.read()) != '\n') {
            sb.append(c);
        }
        sb.append(c);
        return sb.toString();
    }

    public boolean hasMoreLines() throws IOException {
        return fileReader.ready();
    }
}
