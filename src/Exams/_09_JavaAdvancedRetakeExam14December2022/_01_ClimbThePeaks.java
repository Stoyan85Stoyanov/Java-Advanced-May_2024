package Exams._09_JavaAdvancedRetakeExam14December2022;

import java.util.*;
import java.util.stream.Collectors;

public class _01_ClimbThePeaks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<Integer> foodStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).forEach(foodStack::push);

        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).forEach(staminaQueue::offer);

        List<String> conqueredPeaks = new ArrayList<>();

        Map<String, Integer> mountainsPeaks = new LinkedHashMap<>();
        mountainsPeaks.put("Vihren", 80);
        mountainsPeaks.put("Kutelo", 90);
        mountainsPeaks.put("Banski Suhodol", 100);
        mountainsPeaks.put("Polezhan", 60);
        mountainsPeaks.put("Kamenitza", 70);

        boolean allPeaksConquered = false;

        while (!foodStack.isEmpty() && !staminaQueue.isEmpty()) {

            int food = foodStack.peek();
            int stamina = staminaQueue.peek();

            int totalDifficulty = food + stamina;

            for (Map.Entry<String, Integer> peaks : mountainsPeaks.entrySet()) {

                String peak = peaks.getKey();

                if (totalDifficulty >= peaks.getValue()) {
                    conqueredPeaks.add(peak);
                    mountainsPeaks.remove(peak);
                }
                foodStack.pop();
                staminaQueue.poll();
                break;
            }

            if (conqueredPeaks.size() == 5) {
                allPeaksConquered = true;
                break;

            }
        }

        if (allPeaksConquered) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            System.out.println(conqueredPeaks.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        }
    }
}
