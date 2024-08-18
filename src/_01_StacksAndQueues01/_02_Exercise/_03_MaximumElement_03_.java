package _01_StacksAndQueues01._02_Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _03_MaximumElement_03_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandCount = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commandCount; i++) {
            int command = scanner.nextInt();

            if (command == 1) {  // ако командата е 1 (Push the element X into the stack)
                int numberToPush = scanner.nextInt();
                stack.push(numberToPush);

            } else if (command == 2) {  // ако командата е 2 (Delete the element present at the top of the stack)
                stack.pop();

            } else { // command == 3
                if (!stack.isEmpty()) { // Ако има елементи в стека -> отпечатваме максималния елемент
                    System.out.println();
                    System.out.println(Collections.max(stack));
                }
            }
        }
    }
}
