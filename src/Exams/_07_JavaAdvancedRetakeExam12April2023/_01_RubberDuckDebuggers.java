package Exams._07_JavaAdvancedRetakeExam12April2023;

import java.util.*;

public class _01_RubberDuckDebuggers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        ArrayDeque<Integer> programmerQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(programmerQueue::offer);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(tasksStack::push);

        int totalDarth_Vader_Ducky = 0;
        int totalThor_Ducky = 0;
        int totalBig_Blue_Rubber_Ducky = 0;
        int totalSmall_Yellow_Rubber_Ducky = 0;


        while (!programmerQueue.isEmpty() && !tasksStack.isEmpty()) {

            int programmer = programmerQueue.peek();
            int tasks = tasksStack.peek();

            int totalTime = programmer * tasks;

                  if (totalTime > 0 && totalTime <= 60) {
                      programmerQueue.poll();
                      tasksStack.pop();
                      totalDarth_Vader_Ducky++;

                  } else if (totalTime > 61 && totalTime <= 120) {
                      programmerQueue.poll();
                      tasksStack.pop();
                      totalThor_Ducky++;

                  } else if (totalTime > 121 && totalTime <= 180) {
                      programmerQueue.poll();
                      tasksStack.pop();
                      totalBig_Blue_Rubber_Ducky++;

                  } else if (totalTime > 181 && totalTime <= 240) {
                      programmerQueue.poll();
                      tasksStack.pop();
                      totalSmall_Yellow_Rubber_Ducky++;

                  }else {
                      tasksStack.push(tasksStack.pop() - 2);
                      programmerQueue.offer(programmer);
                      programmerQueue.poll();
                  }

        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d%n", totalDarth_Vader_Ducky);
        System.out.printf("Thor Ducky: %d%n", totalThor_Ducky);
        System.out.printf("Big Blue Rubber Ducky: %d%n", totalBig_Blue_Rubber_Ducky);
        System.out.printf("Small Yellow Rubber Ducky: %d%n", totalSmall_Yellow_Rubber_Ducky);

        }
    }

