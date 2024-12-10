package Exams._03_JavaAdvancedRetakeExam13December2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01_WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> wormSizeStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(wormSizeStack::push);

        ArrayDeque<Integer> holeSizeQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(holeSizeQueue::offer);


        int initialWormCount = wormSizeStack.size();
        int matches = 0;

        while (!wormSizeStack.isEmpty() && !holeSizeQueue.isEmpty()) {

            int worm = wormSizeStack.pop();
            int hole = holeSizeQueue.poll();

            if (worm == hole) {
                matches++;

            } else {
                worm -= 3;

                if (worm > 0) {
                    wormSizeStack.push(worm);
                }
            }
        }

        if (matches > 0) {
            System.out.println("Matches: " + matches);

        } else {
            System.out.println("There are no matches.%n");
        }

        if (wormSizeStack.isEmpty() && initialWormCount == matches) {
            System.out.println("Every worm found a suitable hole!");

        } else if (wormSizeStack.isEmpty() && initialWormCount > matches) {
            System.out.println("Worms left: none");

        } else if (!wormSizeStack.isEmpty()) {

            List<Integer> reversedStack = new ArrayList<>(wormSizeStack);
            Collections.reverse(reversedStack);

            String output = reversedStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Worms left: " + output);
        }

        if (holeSizeQueue.isEmpty()) {
            System.out.println("Holes left: none");

        } else {
            String output = holeSizeQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Holes left: " + output);
        }
    }
}

