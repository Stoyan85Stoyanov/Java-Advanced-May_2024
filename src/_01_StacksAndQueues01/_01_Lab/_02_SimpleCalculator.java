package _01_StacksAndQueues01._01_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _02_SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque <String> tokens = new ArrayDeque<>();
        Collections.addAll(tokens, input);

        while (tokens.size() > 1) {
            int firstNumber = Integer.parseInt(tokens.pop());
            String operator = tokens.pop();
            int secondNumber = Integer.parseInt(tokens.pop());
            int resultNumbers = 0;

            if (operator.equals("+")) {
                   resultNumbers = firstNumber + secondNumber;

            } else if (operator.equals("-")) {
                   resultNumbers = firstNumber - secondNumber;
            }
            tokens.push(String.valueOf(resultNumbers));
        }
        System.out.println(tokens.peek());
    }
}
