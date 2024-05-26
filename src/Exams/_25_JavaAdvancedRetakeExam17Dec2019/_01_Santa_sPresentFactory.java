package Exams._25_JavaAdvancedRetakeExam17Dec2019;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _01_Santa_sPresentFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        for (String input : firstLine) {
            materialsStack.push(Integer.parseInt(input));
        }

        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();
        for (String input : secondLine) {
            magicLevelQueue.offer(Integer.parseInt(input));
        }

        Map<String, Integer> presents = new TreeMap<>();


        presents.put("Doll", 0);
        presents.put("Wooden train", 0);
        presents.put("Teddy bear", 0);
        presents.put("Bicycle", 0);


        while (!materialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {

            int material = materialsStack.peek();
            int magic = magicLevelQueue.peek();

            if (material == 0 || magic == 0) {

                if (materialsStack.peek() == 0) {
                    materialsStack.pop();
                }

                if (magic == 0) {
                    magicLevelQueue.poll();
                }
            }

            int totalMagicNeeded = material * magic;

            switch (totalMagicNeeded) {

                case 150 -> {
                    presents.put("Doll", presents.get("Doll") + 1);
                    materialsStack.pop();
                    magicLevelQueue.poll();
                }
                case 250 -> {
                    presents.put("Wooden train", presents.get("Wooden train") + 1);
                    materialsStack.pop();
                    magicLevelQueue.poll();
                }
                case 300 -> {
                    presents.put("Teddy bear", presents.get("Teddy bear") + 1);
                    materialsStack.pop();
                    magicLevelQueue.poll();
                }
                case 400 -> {
                    presents.put("Bicycle", presents.get("Bicycle") + 1);
                    materialsStack.pop();
                    magicLevelQueue.poll();
                }
                default -> {

                    if (totalMagicNeeded < 0) {
                        int totalSum = material + magic;
                        materialsStack.pop();
                        magicLevelQueue.poll();
                        materialsStack.push(totalSum);

                    } else if (totalMagicNeeded > 0) {
                        magicLevelQueue.poll();
                        materialsStack.push(materialsStack.pop() + 15);

                    }
                }
            }
        }

            boolean firstResult = (presents.get("Doll") > 0 && presents.get("Wooden train") > 0);
            boolean secondResult = (presents.get("Teddy bear") > 0 && presents.get("Bicycle") > 0);

            if (firstResult || secondResult) {
                System.out.println("The presents are crafted! Merry Christmas!");

            }else {
                System.out.println("No presents this Christmas!");
            }

            if (!materialsStack.isEmpty()) {
                System.out.print("Materials left: ");
                System.out.println(materialsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }

            if (!magicLevelQueue.isEmpty()) {
                System.out.print("Magic left: ");
                System.out.println(magicLevelQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
            presents.entrySet().stream().filter(e -> e.getValue() > 0)
                    .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

           }
        }
