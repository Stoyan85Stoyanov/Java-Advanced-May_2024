package _003_SetsAndMapsAdvanced._02_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> tracking = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            String IP = input.split(" ")[0].split("=")[1];
            String userName = input.split(" ")[2].split("=")[1];

            if(tracking.containsKey(userName)) {

                Map<String, Integer> IPAndCount = tracking.get(userName);

                if (IPAndCount.containsKey(IP)) {
                    int count = IPAndCount.get(IP) + 1;
                    IPAndCount.put(IP, count);

                }else {
                    IPAndCount.put(IP, 1);
                }

            }else {
                tracking.put(userName, new LinkedHashMap<>());
                tracking.get(userName).put(IP, 1);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry: tracking.entrySet()) {

            String userName = entry.getKey();
            Map<String, Integer> IPAndCount = entry.getValue();

            String output = IPAndCount.entrySet().stream().map(IPentry -> String.format("%s => %s", IPentry.getKey(), IPentry.getValue()))
                             .collect(Collectors.joining(", "));

            System.out.println(userName + ":");
            System.out.println(output + ".");
        }
    }
}
