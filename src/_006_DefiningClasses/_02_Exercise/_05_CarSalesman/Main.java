package _006_DefiningClasses._02_Exercise._05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        int numberN = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberN; i++) {

            String engineInfo = scanner.nextLine();
            String [] engineDate = engineInfo.split(" ");

            String model = engineDate[0];
            String power = engineDate[1];

            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineDate.length == 4) {
               displacement = engineDate[2];
               efficiency = engineDate[3];

            } else if (engineDate.length == 3) {

                if (Character.isDigit(engineDate[2].charAt(0))) {
                    displacement = engineDate[2];

                }else {
                    efficiency = engineDate[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }
        int numberM = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberM; i++) {

            String carInfo = scanner.nextLine();
            String[] carDate = carInfo.split(" ");


            String carModel = carDate[0];
            String engineModel = carDate[1];
            String carWeight = "n/a";
            String carColor = "n/a";

            if (carDate.length == 4) {
                carWeight = carDate[2];
                carColor = carDate[3];
                
            } else if (carDate.length == 3) {

                if (Character.isDigit(carDate[2].charAt(0))) {
                    carWeight = carDate[2];

                }else {
                    carColor = carDate[2];
                }
            }
            Engine engine = getEngineByModel(engines, engineModel);
            Car car = new Car(carModel, engine, carWeight, carColor);
            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static Engine getEngineByModel(List<Engine> engines, String engineModel) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(engineModel)) {
                return engine;
            }
        }
        return null;
    }
}
