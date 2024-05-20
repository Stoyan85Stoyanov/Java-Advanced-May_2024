package _003_SetsAndMapsAdvanced._01_Lab;

import java.util.*;

public class _07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Map<String, List<String>>> infoMap = new LinkedHashMap<>();

        while (number-- > 0) {
            String[] inputArr = scanner.nextLine().split(" ");
            String continent = inputArr[0];
            String country = inputArr[1];
            String city = inputArr[2];

            infoMap.putIfAbsent(continent, new LinkedHashMap<>());
            infoMap.get(continent).putIfAbsent(country, new ArrayList<>());
            infoMap.get(continent).get(country).add(city);
        }

        infoMap.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((k, v) -> System.out.printf("  %s -> %s%n", k, String.join(", ", v)));
        });
    }
 }


