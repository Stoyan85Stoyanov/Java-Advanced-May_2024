package _004_StreamsFilesAndDirectories._02_Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _01_SumLines {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> inputs = Files.readAllLines(Path.of(path));

        for (String input: inputs) {
            int sum = 0;

            for (char symbol: input.toCharArray()) {
                sum+=symbol;
            }
            System.out.println(sum);
        }
    }
}
