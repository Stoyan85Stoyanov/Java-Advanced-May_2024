package Exams._11_JavaAdvancedRetakeExam18August2022;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Kat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(", ");
        ArrayDeque<Integer> licensePlatesQueue = new ArrayDeque<>();
        for (String input : firstLine) {
            licensePlatesQueue.offer(Integer.parseInt(input));
        }

        String[] secondLine = scanner.nextLine().split(", ");
        ArrayDeque<Integer> carsStack = new ArrayDeque<>();
        for (String input : secondLine) {
            carsStack.push(Integer.parseInt(input));
        }

        int countDays = 0;
        int countRegisteredCars = 0;


        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {


            int currentPlates = licensePlatesQueue.poll();
            int currentCars = carsStack.pop();

            int licensePlates = currentCars * 2;
            int registeredCars = currentPlates / 2;

            if (currentPlates > licensePlates) {

                currentPlates = currentPlates - licensePlates;
                countRegisteredCars = countRegisteredCars + currentCars;
                licensePlatesQueue.offer(currentPlates);

            } else if (currentPlates < licensePlates) {

                currentCars = currentCars - registeredCars;
                countRegisteredCars = countRegisteredCars + registeredCars;
                carsStack.offer(currentCars);

            } else {
                countRegisteredCars = countRegisteredCars + currentCars;
            }
            countDays++;
        }

        System.out.printf("%d cars were registered for %d days!%n", countRegisteredCars, countDays);

        if (!licensePlatesQueue.isEmpty()) {
            System.out.println(licensePlatesQueue.stream().mapToInt(value -> value).sum() + " license plates remain!");

        }else if (!carsStack.isEmpty()) {

            int countCarsLicensePlates = 0;

            for (int car : carsStack) {
                countCarsLicensePlates = countCarsLicensePlates + car;
            }
            System.out.printf("%d cars remain without license plates!", countCarsLicensePlates);
        }

        if (licensePlatesQueue.isEmpty() && carsStack.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
