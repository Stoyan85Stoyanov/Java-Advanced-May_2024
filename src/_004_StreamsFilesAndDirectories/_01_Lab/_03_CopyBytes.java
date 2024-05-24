package _004_StreamsFilesAndDirectories._01_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_CopyBytes {
    public static void main(String[] args) throws IOException {

        String inputPath =  "C:\\Users\\User\\Desktop\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\User\\Desktop\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);

        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int oneByte = inputStream.read();

        while (oneByte != -1) {

            if (oneByte == 32) {
                outputStream.write(' ');
            } else if (oneByte == 10) {
                outputStream.write('\n');
            } else {
                String message = String.valueOf(oneByte);

                for (char c : message.toCharArray()) {
                    outputStream.write(c);
                }

            }
            oneByte = inputStream.read();
        }
    }
}
