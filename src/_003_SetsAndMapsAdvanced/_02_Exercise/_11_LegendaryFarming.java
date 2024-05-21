package _003_SetsAndMapsAdvanced._02_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _11_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Integer> legendary = new HashMap<>();
        Map<String, Integer> junk = new HashMap<>();

        legendary.put("shards", 0);
        legendary.put("fragments", 0);
        legendary.put("motes", 0);

        boolean isCollected = false;
        while (!isCollected) {

            String[] tokens = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < tokens.length && !isCollected; i += 2) {

                String mat = tokens[i + 1];
                int amount = Integer.parseInt(tokens[i]);

                if (mat.equals("shards") || mat.equals("fragments") || mat.equals("motes")) {

                    amount += legendary.get(mat);

                    if (amount >= 250) {
                        amount -= 250;

                        isCollected = true;

                        switch (mat) {
                            case "shards" -> System.out.println("Shadowmourne obtained!");
                            case "fragments" -> System.out.println("Valanyr obtained!");
                            case "motes" -> System.out.println("Dragonwrath obtained!");
                        }
                    }
                    legendary.put(mat, amount);

                } else {
                    if (junk.containsKey(mat)) {
                        junk.put(mat, junk.get(mat) + amount);

                    } else {
                        junk.put(mat, amount);
                    }
                }
            }
        }
        legendary.entrySet().stream().sorted((e1, e2) -> {
                    if (e2.getValue().compareTo(e1.getValue()) == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return e2.getValue().compareTo(e1.getValue());
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junk.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}


