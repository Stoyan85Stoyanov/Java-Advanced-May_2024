package _003_SetsAndMapsAdvanced._02_Exercise;

import java.util.*;

public class _10_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> usersTime = new TreeMap<>();
        Map<String, Set<String>> addresses = new TreeMap<>();

        while (number-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String ip = tokens[0];
            String name = tokens[1];
            
            int time = Integer.parseInt(tokens[2]);

            if (!usersTime.containsKey(name)) {
                usersTime.put(name, time);
                addresses.put(name, new TreeSet<>());
                addresses.get(name).add(ip);
                
            } else {
                usersTime.put(name, usersTime.get(name) + time);
                addresses.get(name).add(ip);
            }
        }

        usersTime.forEach((key, value) -> System.out.printf("%s: %d %s%n", key, value, addresses.get(key).toString()));

    }
}



