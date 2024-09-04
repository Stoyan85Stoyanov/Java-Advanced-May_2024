package _03_DefiningClasses03._01_Lab._01_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCars = Integer.parseInt(scanner.nextLine()); // броя коли от конзолата

        List <Car> carsCollections = new ArrayList<>(); // списък с колите

        for (int i = 0; i < numberCars; i++) {  // обхождаме броя коли

            String [] carData = scanner.nextLine().split("\\s+"); // четем от конзолата ред по ред
            String brand = carData [0]; // четем марката
            String model = carData [1]; // четем модела
            int horsePower = Integer.parseInt(carData [2]); // четем конските сили

            Car car = new Car(); // създаваме си колата

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carsCollections.add(car); // в колекцията с коли добавяме нашата кола
        }
        carsCollections.forEach(car -> System.out.println(car.carInfo())); // принтираме
    }
}
