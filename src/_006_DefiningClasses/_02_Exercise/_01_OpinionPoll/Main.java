package _006_DefiningClasses._02_Exercise._01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

         int n = Integer.parseInt(scanner.nextLine());

         List <Person> piopleList = new ArrayList<>();

         for (int i = 0; i < n; i++) {

         String personalInformation = scanner.nextLine();

         String name = personalInformation.split("\\s+")[0];
         int age = Integer.parseInt(personalInformation.split("\\s+")[1]);

         Person person = new Person(name, age);

         if (age > 30){
             piopleList.add(person);
         }
    }

        piopleList.sort(Comparator.comparing(Person::getName));

        for (Person person: piopleList) {
            System.out.println(person);
        }
    }
}
