package Exams._23_JavaAdvancedRegularExam28June2020._03_Parking;

public class Car {
    private String manufacturer;
    private String model;
    private int year;


    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return String.format("%s %s (%d)",this.manufacturer, this.model, this.year);
    }
}
