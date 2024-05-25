package Exams._26_JavaAdvancedRegularExam26Oct2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(malesStack::push);

        ArrayDeque<Integer> femalesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        int matchesCount = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {

            int male = malesStack.peek();
            int female = femalesQueue.peek();


            if (male <= 0) {
                malesStack.pop();
                continue;

            } else if (female <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;

            } else if (female % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }

            if (male == female) {
                matchesCount++;
                malesStack.pop();
                femalesQueue.poll();

            } else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2);
            }

        }
        System.out.printf("Matches: %d%n", matchesCount);

        if (!malesStack.isEmpty()) {
            System.out.println("Males left: " + malesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        } else {
            System.out.println("Males left: none");
        }

        if (!femalesQueue.isEmpty()) {
            System.out.println("Females left: " + femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        } else {
            System.out.println("Females left: none");

        }
    }
}


