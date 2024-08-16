package JavaAdvancedExam_22_06_2024.vintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge ){
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRailGauge() {
        return railGauge;
    }
    public List<Locomotive> getLocomotives() {
        return locomotives;
    }
    public void addLocomotive(Locomotive locomotive) {
        //Метод addLocomotive(Locomotive locomotive) – добавя обект към колекцията от локомотиви,
        // ако място за него и междурелсието на гарата съвпада с междурелсието на локомотива,
        // в противен случай отпечатайте:
        //o "Тази гара е пълна!"
        //Ако релсовото междурелсие на гарата не съвпада с междурелсието на отпечатъка на локомотива:
        //o "Желсовото междурелсие на тази гара не съвпада с междурелсието на локомотива!
        // Разлика: {разликата между междурелсието на гарата и междурелсието на локомотива в абсолютна стойност} mm."

        int difference = Math.abs(locomotive.getGauge() - this.railGauge);
        if (locomotives.size() < capacity) {
            if (this.getRailGauge() == locomotive.getGauge()) {
                if (locomotives.stream().anyMatch(s -> s.getName().equals(locomotive.getName()))) {
                    throw new RuntimeException("This locomotive already exists!");
                }
                locomotives.add(locomotive);
            } else {
                System.out.printf("The rail gauge of this station does not match the locomotive gauge!"
                        + " Difference: %d mm.%n", difference);
            }
        } else {
            System.out.println(("This train station is full!"));
        }
    }
    public int getCount()  { // връща брой локомотиви в дадена гара
        return this.locomotives.size();
    }
    public String getOldestLocomotive() {
          // връща String – името на най-стария локомотив в дадената гара
        Locomotive oldestLocomotive = locomotives.stream().min(Comparator.comparing(Locomotive::getBuildDate)).orElse(null);
        if (oldestLocomotive != null) {
            return oldestLocomotive.getName();
        }
          return "There are no locomotives.";  // В противен случай отпечатайте
        }


    public boolean removeLocomotive(String name) {  // премахва локомотив по дадено име, ако такова съществува , и връща булево (вярно , ако е премахнато, в противен случай – невярно )
        Locomotive locomotive = this.getLocomotive(name);
        locomotives.remove(locomotive);
        return locomotive != null;
    }

    public Locomotive getLocomotive(String name) {  // връща локомотива с даденото име , в противен случай – връща null
        return this.locomotives.stream().filter(locomotive -> locomotive.getName().equals(name)).findFirst().orElse(null);
    }

    public String getFastestLocomotive() { //връща String - най-бързият локомотив по скорост в дадена гара
        Locomotive fastestLocomotive = locomotives.stream().max(Comparator.comparing(Locomotive::getMaxSpeed)).orElse(null);

        if (fastestLocomotive != null) { // ако има такъв , в следния формат
            return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.", fastestLocomotive.getName(), fastestLocomotive.getMaxSpeed());

        }
            return "There are no locomotives.";  // Ако в гарата няма локомотиви, отпечатайте

    }

    public String getStatistics() { // връща String в следния формат (отпечатайте локомотивите по реда на добавяне )
        TrainStation trainStation = new TrainStation(getName(), getCapacity(), railGauge);
        StringBuilder builder = new StringBuilder();

        if (locomotives.isEmpty()) {
            builder.append(System.lineSeparator()).append("There are no locomotives departing from ").append(trainStation.getName()).append(" station.");

        } else {
            builder.append("Locomotives departed from ").append(trainStation.getName()).append(":");
            builder.append(System.lineSeparator());
            for (int i = 0; i < locomotives.size(); i++) {
                builder.append(i + 1).append(". ").append(locomotives.get(i).getName()).append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}
