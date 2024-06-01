package _006_DefiningClasses._02_Exercise._05_CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(this.model).append(":").append(System.lineSeparator());
        builder.append("Power: ").append(this.power).append(System.lineSeparator());
        builder.append("Displacement: ").append(this.displacement).append(System.lineSeparator());
        builder.append("Efficiency: ").append(this.efficiency);
        return builder.toString();
    }
}
