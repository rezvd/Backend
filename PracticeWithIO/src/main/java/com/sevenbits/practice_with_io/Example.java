package com.sevenbits.practice_with_io;

import java.io.IOException;

public class Example {

    public int getLongestLineCharCount(FileReader reader) throws IOException {
        int max = 0;
        while(reader.hasMoreLines()) {
            String string = reader.readLine();
            int length = string.length();
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
}
