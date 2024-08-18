package Exams._10_JavaAdvancedRegularExam22October2022;

import java.util.*;
import java.util.stream.Collectors;

public class _01_EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(caffeineStack::push);

        ArrayDeque<Integer> energyDrinksQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(energyDrinksQueue::offer);

         int quantityCaffeine = 0;


        while (!caffeineStack.isEmpty() && !energyDrinksQueue.isEmpty()) {

            int caffeine = caffeineStack.peek();
            int energyDrinks = energyDrinksQueue.peek();

            int totalCaffeine = caffeine * energyDrinks;
            int remainder = 300 - quantityCaffeine;

            if (totalCaffeine <= remainder) {
                caffeineStack.pop();
                energyDrinksQueue.poll();
                quantityCaffeine += totalCaffeine;

            }else {
                caffeineStack.pop();
                energyDrinksQueue.poll();
                energyDrinksQueue.offer(energyDrinks);
                quantityCaffeine -= 30;

                if (quantityCaffeine < 0) {
                    quantityCaffeine = 0;
                }
            }
        }

        if (!energyDrinksQueue.isEmpty()) {

            String output = energyDrinksQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Drinks left: " + output);

        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", quantityCaffeine);
    }
}
