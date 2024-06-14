package _009_IteratorsAndComparators._02_Exercise._02_Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(elements);

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            switch (command) {
                case "HasNext" -> System.out.println(listyIterator.iterator().hasNext());
                case "Move" -> System.out.println(listyIterator.move());
                case "Print" -> {
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case "PrintAll" -> {
                    try {
                        listyIterator.printAll();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            command = scanner.nextLine();
        }
    }
}
