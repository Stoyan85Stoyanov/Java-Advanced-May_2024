package _001_StacksAndQueues_02_Exercise_2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();

        ArrayDeque <String> textHistory = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int command = 1; command <= n; command++) {

        String [] input = scanner.nextLine().split(" ");

            switch (input[0]) {

                case "1" -> {
                    textHistory.push(text.toString());
                    text.append(input[1]);
                }

                case "2" -> {
                    textHistory.push(text.toString());
                    int countToBeDeleted = Integer.parseInt(input[1]);
                    int startDeletingPosition = text.length() - countToBeDeleted;
                    text.delete(startDeletingPosition, text.length());
                }

                case "3" -> {
                    int index = Integer.parseInt(input[1]) - 1;
                    System.out.println(text.charAt(index));
                }

                case "4" -> text = new StringBuilder(textHistory.pop());
            }
        }
    }
}
