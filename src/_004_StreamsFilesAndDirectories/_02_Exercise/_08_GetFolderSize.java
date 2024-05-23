package _004_StreamsFilesAndDirectories._02_Exercise;

import java.io.File;
import java.util.Objects;

public class _08_GetFolderSize {
    public static void main(String[] args) {

        String folderPath = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        int size = 0;
        File folder = new File(folderPath);

        for (File file: Objects.requireNonNull(folder.listFiles())) {
            size += file.length();

        }
        System.out.println("Folder size: " + size);
    }
}
