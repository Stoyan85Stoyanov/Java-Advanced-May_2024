package Exams._03_JavaAdvancedRetakeExam13December2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01_WormsAndHoles_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> wormSizeStack = new ArrayDeque<>();
        for (String input : firstLine) {
            wormSizeStack.push(Integer.parseInt(input));
        }

        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> holeSizeQueue = new ArrayDeque<>();
        for (String input : secondLine) {
            holeSizeQueue.offer(Integer.parseInt(input));
        }

        int initialWormCount = wormSizeStack.size();
        int matchesCount = 0;

        while (!wormSizeStack.isEmpty() && (!holeSizeQueue.isEmpty())) {

            int worm = wormSizeStack.peek();
            int hole = holeSizeQueue.peek();

            if (worm == hole) {
                wormSizeStack.pop();
                holeSizeQueue.poll();
                matchesCount++;

            } else {
                wormSizeStack.push(wormSizeStack.pop() - 3);
                if (wormSizeStack.peek() <= 0) {
                    wormSizeStack.pop();
                }
                holeSizeQueue.poll();
            }
        }

        if (matchesCount > 0) {
            System.out.println("Matches: " + matchesCount);

        } else {
            System.out.println("There are no matches.");
        }

        if (wormSizeStack.isEmpty() && initialWormCount == matchesCount) {
            System.out.println("Every worm found a suitable hole!");

        } else if (wormSizeStack.isEmpty() && initialWormCount > matchesCount) {
            System.out.println("Worms left: none");

        } else if (!wormSizeStack.isEmpty()) {

            List<Integer> reversedStack = new ArrayList<>(wormSizeStack);
            Collections.reverse(reversedStack);

            System.out.println("Worms left: " + reversedStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (holeSizeQueue.isEmpty()) {
            System.out.println("Holes left: none");

        } else {
            System.out.println("Holes left: " + holeSizeQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
