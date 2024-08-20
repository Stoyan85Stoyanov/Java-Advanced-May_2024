package _01_StacksAndQueues01._02_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_InfixToPostfix_08_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        for (String current : input) {

            if (!"-+/*()".contains(current)) {
                outputQueue.offer(current);

            } else if (current.equals("(")) {
                operatorsStack.push(current);

            } else if (current.equals(")") && (!operatorsStack.isEmpty() && !operatorsStack.peek().equals("("))) {
                outputQueue.offer(operatorsStack.pop());
                operatorsStack.pop();

            } else {

                if ("-+".contains(current)) {

                    while (!operatorsStack.isEmpty() && !operatorsStack.peek().equals("(")) {
                        outputQueue.offer(operatorsStack.pop());
                    }

                } else {

                    while (!operatorsStack.isEmpty() && !"+-(".contains(operatorsStack.peek())) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                }
                operatorsStack.push(current);
            }
        }

        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }

        outputQueue.forEach(e -> System.out.print(e + " "));
    }
}

