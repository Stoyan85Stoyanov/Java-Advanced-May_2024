package _005_FunctionalProgramming._01_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _05_FilterByAge {

    private static class Person {
        String name;
        int age;

        Person(String name, int age) {
           this.name = name;
           this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();


        while (number --> 0) {

            String[] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

         String areCriteria = scanner.nextLine();
         int age = Integer.parseInt(scanner.nextLine());
         String format = scanner.nextLine();

        Predicate<Person> personPredicate = getPersonPredicate(areCriteria, age);

        Consumer<Person> printer = getPrinter(format);

        filterAndPrintPeople(personPredicate, printer, people);
    }

    private static void filterAndPrintPeople(Predicate<Person> predicate, Consumer<Person> consumer, List<Person> people) {

        people.stream().filter(predicate).forEach(consumer);
    }


    private static Consumer<Person> getPrinter(String format) {

        return  switch (format) {

            case "name age" -> person -> System.out.println(person.name + " - " + person.age);
            case "name" -> person -> System.out.println(person.name);
            case "age" -> person -> System.out.println(person.age);
            default -> throw new IllegalArgumentException("Unsupported input type");

        };
    }


    private static Predicate<Person> getPersonPredicate (String areCriteria, int age) {

        return switch (areCriteria) {

            case "younger" -> person -> person.age <= age;
            case "older" -> person -> person.age >= age;
            default -> throw new IllegalArgumentException("Unsupported input value");

        };
    }
}



