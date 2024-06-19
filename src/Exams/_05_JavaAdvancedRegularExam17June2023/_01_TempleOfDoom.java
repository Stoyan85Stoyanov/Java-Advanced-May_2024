package Exams._05_JavaAdvancedRegularExam17June2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01_TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            toolsQueue.offer(Integer.parseInt(input));
        }

        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        for (String input : secondLine) {
            substancesStack.push(Integer.parseInt(input));
        }

        String[] thirdLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> challenges = new ArrayDeque<>();
        for (String input : thirdLine) {
            challenges.offer(Integer.parseInt(input));
        }


        while (!toolsQueue.isEmpty() && (!substancesStack.isEmpty())) {

            int firstNumber = toolsQueue.peek();
            int secondNumber = substancesStack.peek();

            int sumTotal = firstNumber * secondNumber;


            if (challenges.contains(sumTotal)) {
                challenges.remove(sumTotal);
                toolsQueue.poll();
                substancesStack.pop();

                if (challenges.isEmpty()) {
                    System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                    break;
                }


            } else {
                toolsQueue.offer(toolsQueue.poll() + 1);
                substancesStack.push(substancesStack.pop() - 1);

                if (substancesStack.peek() == 0) {
                    substancesStack.pop();
                }


                if (substancesStack.isEmpty()) {
                    System.out.println("Harry is lost in the temple. Oblivion awaits him.");
                    break;
                }
            }
        }

        if (!toolsQueue.isEmpty()) {
            System.out.print("Tools: " + toolsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }
        if (!substancesStack.isEmpty()) {
            System.out.print("Substances: " + substancesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }
        if (!challenges.isEmpty()) {
            System.out.print("Challenges: " + challenges.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }
    }
}
