package _003_SetsAndMapsAdvanced._02_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
     Scanner scanner = new Scanner (System.in);

     Set<String> usernames = new LinkedHashSet<>();

     int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String username = scanner.nextLine();
            usernames.add(username);

        }
        usernames.forEach(username -> System.out.println(username));
    }
}
