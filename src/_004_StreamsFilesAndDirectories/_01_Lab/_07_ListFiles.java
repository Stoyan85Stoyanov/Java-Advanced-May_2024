package _004_StreamsFilesAndDirectories._01_Lab;

import java.io.File;
import java.util.Scanner;

public class _07_ListFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(fileName);

        File[] innerFiles = file.listFiles();

        for (File innerFile : innerFiles) {
            if (!innerFile.isDirectory()) {
                System.out.printf("%s: [%d]%n", innerFile.getName(), innerFile.length());

            }
        }
    }
}
