package _004_StreamsFilesAndDirectories._01_Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class _01_ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int asciiCode = inputStream.read();

        while (asciiCode != -1) {
            System.out.print(Integer.toBinaryString(asciiCode) + " ");
            asciiCode = inputStream.read();
        }
    }
}
