package _004_StreamsFilesAndDirectories._02_Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _05_LineNumbers {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        List<String> inputs = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        int counter = 1;

        for (String input: inputs) {
            String output = String.format("%d. %s",counter,input);
            counter++;
            writer.println(output);
        }
        writer.close();
    }
}
