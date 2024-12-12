package Exams._15_JavaAdvancedRetakeExam15December2021;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        for (String input : firstLine) {
            malesStack.push(Integer.parseInt(input));
        }
        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        for (String input : secondLine) {
            femalesQueue.offer(Integer.parseInt(input));
        }

        int matchesCount = 0;


        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {

            int firstNumber = malesStack.peek();
            int secondNumber = femalesQueue.peek();

            if (firstNumber <= 0 ) {
                malesStack.pop();

            } else if (secondNumber <= 0) {
                femalesQueue.poll();

            }  else if (firstNumber % 25 == 0) {
                malesStack.pop();


            } else if (secondNumber % 25 == 0) {
                femalesQueue.poll();

            } else if (firstNumber == secondNumber) {
                malesStack.pop();
                femalesQueue.poll();
                matchesCount++;

            } else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2);
            }
        }

        System.out.printf("Matches: %d%n", matchesCount);

        if (!malesStack.isEmpty()) {
            System.out.print("Males left: " + malesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();

        }else {
            System.out.println("Males left: none");
        }

        if (!femalesQueue.isEmpty()) {
            System.out.print("Females left: " + femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();

        }else {
            System.out.print("Females left: none");
            System.out.println();

        }
    }
}
