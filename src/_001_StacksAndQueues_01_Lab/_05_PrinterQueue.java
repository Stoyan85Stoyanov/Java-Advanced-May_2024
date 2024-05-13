package _001_StacksAndQueues_01_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> requests = new ArrayDeque<>();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                if (requests.isEmpty()) {
                    System.out.println("Printer is on standby");

                } else {
                    String firstRequestsInQueue = requests.poll();
                    System.out.printf("Canceled %s%n", firstRequestsInQueue);
                }

            } else {
                requests.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String request : requests) {
            System.out.println(request);
        }
    }
}
