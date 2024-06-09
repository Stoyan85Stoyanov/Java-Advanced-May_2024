package Exams._23_JavaAdvancedRegularExam28June2020._03_Parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {

    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(models -> models.getManufacturer().equals(manufacturer) && models.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (Car car : data) {
            text.append(car.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
