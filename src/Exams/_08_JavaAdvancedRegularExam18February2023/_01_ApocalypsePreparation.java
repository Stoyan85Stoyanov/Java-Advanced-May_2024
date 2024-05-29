package Exams._08_JavaAdvancedRegularExam18February2023;

import java.util.*;
import java.util.stream.Collectors;

public class _01_ApocalypsePreparation {

    private static final int Patch = 30;
    private static final int Bandage = 40;
    private static final int MedKit = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] firstLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            textilesQueue.offer(Integer.parseInt(input));
        }

        String[] secondLine = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> medicamentStack = new ArrayDeque<>();
        for (String input : secondLine) {
            medicamentStack.push(Integer.parseInt(input));
        }

        int amountPatch = 0;
        int amountBandage = 0;
        int amountMedKit = 0;


        while (!medicamentStack.isEmpty() && (!textilesQueue.isEmpty())) {

            int firstNumber = textilesQueue.peek();
            int secondNumber = medicamentStack.peek();

            int sumNumber = firstNumber + secondNumber;


            switch (sumNumber) {

                case Patch -> {

                    textilesQueue.poll();
                    medicamentStack.pop();
                    amountPatch++;
                }

                case Bandage -> {

                    textilesQueue.poll();
                    medicamentStack.pop();
                    amountBandage++;
                }

                case MedKit -> {

                    textilesQueue.poll();
                    medicamentStack.pop();
                    amountMedKit++;
                }

                default -> {

                    if (sumNumber > MedKit) {
                        amountMedKit++;
                        textilesQueue.poll();
                        medicamentStack.pop();

                        int result = sumNumber - MedKit;
                        medicamentStack.push(medicamentStack.pop() + result);


                    } else {
                        textilesQueue.poll();
                        medicamentStack.push(medicamentStack.pop() + 10);

                    }
                }
            }
        }

        if (medicamentStack.isEmpty() && textilesQueue.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");

        } else if (medicamentStack.isEmpty()) {
            System.out.println("Medicaments are empty.");

        } else {
            System.out.println("Textiles are empty.");
        }


        TreeMap<String, Integer> medicament = new TreeMap<>();

        if(amountPatch > 0) {
            medicament.put("Patch" , amountPatch);
        }

        if(amountBandage > 0) {
            medicament.put("Bandage" , amountBandage);
        }

        if(amountMedKit > 0) {
            medicament.put("MedKit" , amountMedKit);
        }
        medicament.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(entry -> {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());});



        if (!medicamentStack.isEmpty()) {
                System.out.printf("Medicaments left: %s%n", medicamentStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }


        if (!textilesQueue.isEmpty()) {
                System.out.printf("Textiles left: %s%n", textilesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}

