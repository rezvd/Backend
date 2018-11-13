package com.sevenbits.practice_with_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        try (InputStream inFileStream = new FileInputStream(new File("Homework3.txt"));
             InputStream inBS = new BufferedInputStream(inFileStream);
             OutputStream outFileStream = new FileOutputStream(new File("MyHomework.txt"));
             OutputStream outBS = new BufferedOutputStream(outFileStream)) {
            int[] bytes = new int[1000];
            int n = 0;
            while(inBS.available() != 0) {
                bytes[n] = inBS.read();
                n++;
            }
            for(int i = 0; i < n; i++) {
                outBS.write(bytes[i]);
            }
            String name = "\nRezvanova";
            outBS.write(name.getBytes());
        }
    }
}
