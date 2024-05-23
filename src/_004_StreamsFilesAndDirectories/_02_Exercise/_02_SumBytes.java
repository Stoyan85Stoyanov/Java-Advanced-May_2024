package _004_StreamsFilesAndDirectories._02_Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _02_SumBytes {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        int sum = 0;

        String input = bufferedReader.readLine();
        while (input != null) {
            for (char symbol: input.toCharArray()) {
                sum += symbol;
            }
            input = bufferedReader.readLine();
        }
        System.out.println(sum);
    }
}
