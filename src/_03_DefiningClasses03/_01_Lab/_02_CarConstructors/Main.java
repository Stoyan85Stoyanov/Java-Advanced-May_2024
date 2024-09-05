package _03_DefiningClasses03._01_Lab._02_CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCars = Integer.parseInt(scanner.nextLine());
        Car car;

        for (int i = 0; i < numberCars; i++) {
            String[] carData = scanner.nextLine().split("\\s+");

            if (carData.length == 1) {
                car = new Car(carData[0]);
            } else {
                car = new Car(carData[0], carData[1], Integer.parseInt(carData[2]));
            }

            System.out.println(car);
        }
    }
}
