package _005_FunctionalProgramming._02_Exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        List<String> peoples = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        HashMap<String, Predicate<String>> predicateMap = new HashMap<>();

        String commands = scanner.nextLine();

        while (!commands.equals("Print")) {

            String[] input = commands.substring(commands.indexOf(";") + 1).split("([ ;]+)");

            int index = 2;
            if (input.length == 2) {
                index = 1;
            }

            String name = input[0] + input[index];


            if (commands.contains("Add")) {
                Predicate<String> predicate;

                switch (input[0]) {

                    case "Starts" -> {
                        predicate = s -> s.startsWith(input[2]);
                        predicateMap.putIfAbsent(name, predicate);
                    }

                    case "Ends" -> {
                        predicate = s -> s.endsWith(input[2]);
                        predicateMap.putIfAbsent(name, predicate);
                    }

                    case "Length" -> {
                        predicate = s -> s.length() == Integer.parseInt(input[2]);
                        predicateMap.putIfAbsent(name, predicate);
                    }

                    case "Contains" -> {
                        predicate = s -> s.contains(input[1]);
                        predicateMap.putIfAbsent(name, predicate);
                    }
                }

            } else {
                predicateMap.remove(name);
            }

            commands = scanner.nextLine();
        }

        for (String people : peoples) {
            boolean isGoing = true;

            for (String entry : predicateMap.keySet()) {

                if (predicateMap.get(entry).test(people)) {
                    isGoing = false;
                    break;
                }
            }

            if (isGoing) {
                System.out.printf("%s ", people);
            }
        }
    }
}
