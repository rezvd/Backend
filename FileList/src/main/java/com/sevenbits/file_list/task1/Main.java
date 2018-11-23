package com.sevenbits.file_list.task1;


import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
    final static int STRING_COUNT_TO_FLUSH = 5;

    public static void main(String[] args) throws IOException {
        printList("./test");
        printListWithNio("./test");
    }

    static void printList(final String fileName) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fileList.txt"), Charset.forName("UTF-8")))) {
            File file = new File(fileName);
            print(file, writer, 0);
        }
    }

    static void print(final File file, final Writer writer, int n) throws IOException {
        String s = ", ";
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            //printOneFile(file, sb);
        }
        File[] files = file.listFiles();
        for (File current : files) {
            printOneFile(current, sb);
            writer.write(sb.toString());
            sb.delete(0, sb.length());
            if (++n % STRING_COUNT_TO_FLUSH == 0) {
                writer.flush();
            }
            if (current.isDirectory()) {
                print(current, writer, n);
            }
        }
    }

    static void printOneFile(File file, StringBuilder sb) {
        String s = ", ";
        sb.append(file.getName()).append(s);
        sb.append(file.isDirectory() ? "Directory" : "File");
        sb.append(s);
        sb.append(file.canRead() ? 'r' : '-');
        sb.append(file.canWrite() ? 'w' : '-');
        sb.append(file.canExecute() ? 'x' : '-');
        sb.append(s);
        sb.append(file.getAbsolutePath());
        sb.append("\n\n");

    }

    static void printListWithNio(final String fileName) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fileListNIO.txt"),
                Charset.forName("UTF-8")))) {
            String s = ", ";
            FileSystem fs = FileSystems.getDefault();
            Path path = fs.getPath(fileName);
            Stream<Path> files = Files.walk(path);
            Path[] paths = files.toArray(Path[]::new);
            int n = 0;
            for (Path current : paths) {
                StringBuilder sb = new StringBuilder();
                sb.append(current.getFileName()).append(s);
                sb.append(Files.isDirectory(current) ? "Directory" : "File").append(s);
                sb.append(Files.isReadable(current) ? 'r' : '-');
                sb.append(Files.isWritable(current) ? 'w' : '-');
                sb.append(Files.isExecutable(current) ? 'x' : '-');
                sb.append(s);
                sb.append(current.toAbsolutePath());
                sb.append("\n\n");
                writer.write(sb.toString());
                if (++n % STRING_COUNT_TO_FLUSH == 0) {
                    writer.flush();
                }
            }
        }
    }
}
