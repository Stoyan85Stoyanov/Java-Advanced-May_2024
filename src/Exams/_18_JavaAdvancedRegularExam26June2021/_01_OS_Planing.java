package Exams._18_JavaAdvancedRegularExam26June2021;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_OS_Planing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(", ");
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        for (String input : firstLine) {
            tasksStack.push(Integer.parseInt(input));
        }

        String[] secondLine = scanner.nextLine().split(" ");
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        for (String input : secondLine) {
            threadsQueue.offer(Integer.parseInt(input));
        }

        int valueTaskKilled = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        while (!tasksStack.isEmpty() && (!threadsQueue.isEmpty())) {

            int firstNumber = tasksStack.peek();
            int secondNumber = threadsQueue.peek();

            if (firstNumber == valueTaskKilled) {
                isFound = true;
                break;
            }

            if (secondNumber >= firstNumber) {
                tasksStack.pop();
                threadsQueue.poll();

            } else {
                threadsQueue.poll();

            }
        }

        if (isFound){
            System.out.printf("Thread with value %d killed task %d%n", threadsQueue.peek(), valueTaskKilled);
        }
        System.out.println(threadsQueue.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}