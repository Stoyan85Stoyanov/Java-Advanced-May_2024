package JavaAdvancedExam_22_06_2024.vintageLocos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Locomotive {
    private String name;
    private String builder;
    private LocalDate buildDate;
    private int gauge;
    private int weight;
    private int maxSpeed;

    public Locomotive(String name, String builder, LocalDate buildDate, int gauge, int weight, int maxSpeed ) {

        this.name = name;
        this.builder = builder;
        this.gauge = gauge;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.buildDate = buildDate;
    }

    public String getName() {
        return name;
    }

    public String getBuilder() {
        return builder;
    }

    public int getGauge() {
        return gauge;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public LocalDate getBuildDate() {
        return buildDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public void setGauge(int gauge) {
        this.gauge = gauge;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setBuildData(LocalDate buildData) {
        this.buildDate = buildData;
    }

    @Override
    public String toString() {
        LocalDate date = LocalDate.from(getBuildDate());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String formattedDate = date.format(formatter);

        return String.format("This %s is made by %s at %s." ,getName() , getBuilder(), formattedDate);
    }
}
