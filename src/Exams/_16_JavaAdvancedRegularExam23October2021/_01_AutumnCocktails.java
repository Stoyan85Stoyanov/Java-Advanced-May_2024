package Exams._16_JavaAdvancedRegularExam23October2021;

import java.util.*;

public class _01_AutumnCocktails {

    private static final int Pear_Sour = 150;
    private static final int The_Harvest = 250;
    private static final int Apple_Hinny = 300;
    private static final int High_Fashion = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cocktails = new HashMap<>();


        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        for (String token : tokens) {
            ingredientsQueue.offer(Integer.parseInt(token));
        }

        tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        for (String token : tokens) {
            freshnessStack.push(Integer.parseInt(token));
        }

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {


            int firstIngredients = ingredientsQueue.peek();

            if (firstIngredients == 0) {
                ingredientsQueue.poll();
                continue;
            }
            int lastFreshness = freshnessStack.peek();

            int totalLevels = firstIngredients * lastFreshness;

            switch (totalLevels) {

                case Pear_Sour -> {
                    int currentPearSour = cocktails.get("Pear Sour");
                    currentPearSour++;
                    cocktails.put("Pear Sour", currentPearSour);
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                }
                case The_Harvest -> {
                    int currentTheHarvest = cocktails.get("The Harvest");
                    currentTheHarvest++;
                    cocktails.put("The Harvest", currentTheHarvest);
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                }
                case Apple_Hinny -> {
                    int currentAppleHinny = cocktails.get("Apple Hinny");
                    currentAppleHinny++;
                    cocktails.put("Apple Hinny", currentAppleHinny);
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                }
                case High_Fashion -> {
                    int currentHighFashion = cocktails.get("High Fashion");
                    currentHighFashion++;
                    cocktails.put("High Fashion", currentHighFashion);
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                }
                default -> {
                    freshnessStack.pop();
                    Integer ingredient = ingredientsQueue.poll();
                    ingredient += 5;
                    ingredientsQueue.offer(ingredient);
                }
            }
        }
        if (cocktails.get("Pear Sour") > 0 && cocktails.get("The Harvest") > 0
                && cocktails.get("Apple Hinny") > 0 && cocktails.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");

        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()) {
            int sum = 0;
            for (Integer ingredient : ingredientsQueue) {
                sum += ingredient;

            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        if (cocktails.get("Apple Hinny") > 0) {
            System.out.printf("# Apple Hinny --> %d%n", cocktails.get("Apple Hinny"));
        }
        if (cocktails.get("High Fashion") > 0) {
            System.out.printf("# High Fashion --> %d%n", cocktails.get("High Fashion"));
        }
        if (cocktails.get("Pear Sour") > 0) {
            System.out.printf("# Pear Sour --> %d%n", cocktails.get("Pear Sour"));
        }
        if (cocktails.get("The Harvest") > 0) {
            System.out.printf("# The Harvest --> %d%n", cocktails.get("The Harvest"));
        }
    }
}

