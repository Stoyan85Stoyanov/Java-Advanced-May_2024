package _008_Generics._02_Exercise._08_CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String command = input.split("\\s+")[0];

            switch (command) {

                case "Add" -> {
                    String elementToAdd = input.split("\\s+")[1];
                    list.add(elementToAdd);
                }

                case "Remove" -> {
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    list.remove(index);
                }

                case "Contains" -> {
                    String elementToCheck = input.split("\\s+")[1];
                    System.out.println(list.contains(elementToCheck));
                }

                case "Swap" -> {
                    int index1 = Integer.parseInt(input.split("\\s+")[1]);
                    int index2 = Integer.parseInt(input.split("\\s+")[2]);
                    list.swap(index1, index2);
                }

                case "Greater" -> {
                    String elementToCompareWith = input.split("\\s+")[1];
                    System.out.println(list.countGreaterValues(elementToCompareWith));
                }

                case "Max" -> System.out.println(list.getMax());

                case "Min" -> System.out.println(list.getMin());

                case "Print" -> System.out.println(list);

                case "Sort" -> list.sort();
            }

            input = scanner.nextLine();
        }
    }
}
