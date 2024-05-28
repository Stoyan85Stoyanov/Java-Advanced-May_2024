package _005_FunctionalProgramming._02_Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> peoples = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Party!")) {

            Predicate<String> predicate;

            String criteria = command.split("\\s+")[2];

            if (command.contains("Length")) {
                predicate = x -> x.length() == Integer.parseInt(criteria);

            } else if (command.contains("StartsWith")) {
                predicate = x -> x.startsWith(criteria);

            } else {
                predicate = x -> x.endsWith(criteria);
            }

            if (command.contains("Remove")) {
                ArrayList<String> toRemove = new ArrayList<>();

                for (String people : peoples) {
                    if (predicate.test(people)) {
                        toRemove.add(people);
                    }
                }

                peoples.removeAll(toRemove);

            } else {
                ArrayList<String> toAdd = new ArrayList<>();

                for (String guest : peoples) {
                    if (predicate.test(guest)) {
                        toAdd.add(guest);
                    }
                }
                peoples.addAll(toAdd);
            }

            command = scanner.nextLine();
        }

        if (peoples.isEmpty()) {
            System.out.println("Nobody is going to the party!");

        } else {
            Collections.sort(peoples);
            System.out.print(String.join(", ", peoples) + " are going to the party!");
        }
    }
}
