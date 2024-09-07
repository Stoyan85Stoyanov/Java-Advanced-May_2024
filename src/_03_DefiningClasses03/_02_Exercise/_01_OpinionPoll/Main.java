package _03_DefiningClasses03._02_Exercise._01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

         int n = Integer.parseInt(scanner.nextLine()); // чете от конзолата N реда лична информация

         List <Person> piopleList = new ArrayList<>();  //създаваме един лист в който съхраняваме обекти от класа Person

        for (int i = 0; i < n; i++) {
        String personalInformation = scanner.nextLine(); // прочитаме информация за даден човек ("Peter 12")
         String name = personalInformation.split("\\s+")[0];
         int age = Integer.parseInt(personalInformation.split("\\s+")[1]);

         Person person = new Person(name, age); // създаваме обекта person в класа Person

         if (age > 30){//съхранямаваме хората над 30 години
             piopleList.add(person);
            }
        }
        piopleList.sort(Comparator.comparing(Person::getName));// сортираме списъка по име на хората

        for (Person person: piopleList) { // отпечатваме списъка (всички хора над 30 години)
            System.out.println(person);
        }
    }
}
