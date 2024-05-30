package _006_DefiningClasses._01_Lab._01_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCars = Integer.parseInt(scanner.nextLine());

        List <Car> carsCollections = new ArrayList<>();

        for (int i = 0; i < numberCars; i++) {

            String [] carData = scanner.nextLine().split("\\s+");
            String brand = carData [0];
            String model = carData [1];
            int horsePower = Integer.parseInt(carData [2]);

            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carsCollections.add(car);
        }
        carsCollections.forEach(car -> System.out.println(car.carInfo()));
    }
}
