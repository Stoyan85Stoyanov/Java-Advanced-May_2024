package _004_StreamsFilesAndDirectories._01_Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class _08_NestedFolders {
    public static void main(String[] args) {

        File folder = new File("C:\\Users\\User\\Desktop\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Queue<File> dirs = new ArrayDeque<>();
        dirs.offer(folder);

        int counter = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            counter++;
            System.out.println(current.getName());
        }

        System.out.println(counter + " folders");

    }
}
