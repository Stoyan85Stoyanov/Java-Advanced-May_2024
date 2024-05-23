package _004_StreamsFilesAndDirectories._02_Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class _03_AllCapitals {
    public static void main(String[] args) throws IOException {

        String content = Files.readString(Path.of("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        content = content.toUpperCase();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputs.txt"));
        bufferedWriter.write(content);
        bufferedWriter.close();
    }
}
