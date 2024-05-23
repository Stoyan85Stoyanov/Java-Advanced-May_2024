package _004_StreamsFilesAndDirectories._02_Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class _06_WordCount {
    public static void main(String[] args) throws IOException {

        String [] words = Files.readString(Path.of("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt")).split("\\s+");
        String text = Files.readString(Path.of("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));

        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word: words) {
            wordCount.put(word, 0);
        }
        for (String word: text.split("\\s+")) {
            if (wordCount.containsKey(word)){
                int count = wordCount.get(word) + 1;
                wordCount.put(word, count);
            }
        }
        PrintWriter writer = new PrintWriter("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt");
        wordCount.forEach((key, value) -> writer.println(key + " - " + value));
        writer.close();
    }
}
