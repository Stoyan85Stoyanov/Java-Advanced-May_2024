package _004_StreamsFilesAndDirectories._02_Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String firstFileContent = Files.readString(Path.of("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        String secondFileContent = Files.readString(Path.of("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));

        PrintWriter printWriter = new PrintWriter("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        printWriter.println(firstFileContent);
        printWriter.println(secondFileContent);
        printWriter.close();
    }
}
