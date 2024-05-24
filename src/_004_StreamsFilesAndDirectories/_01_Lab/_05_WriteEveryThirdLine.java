package _004_StreamsFilesAndDirectories._01_Lab;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class _05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inputPath =  "C:\\Users\\User\\Desktop\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\User\\Desktop\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        List<String> strings = Files.readAllLines(Path.of(inputPath));

        List<String> lines = new ArrayList<>();

        for (int i = 2; i < strings.size(); i += 3) {
            lines.add(strings.get(i));
        }

        Files.write(Paths.get(outputPath), lines, StandardCharsets.UTF_8);

    }
}
