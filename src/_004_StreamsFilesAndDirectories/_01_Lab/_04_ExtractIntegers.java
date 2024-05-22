package _004_StreamsFilesAndDirectories._01_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        Scanner scanner = new Scanner(inputStream);

        PrintWriter writer = new PrintWriter("output.txt");



        while (scanner.hasNext()) {

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);

            }else {
                scanner.next();
            }
        }
        writer.flush();
    }
}
