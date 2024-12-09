package Exams._01_JavaAdvancedRetakeExam10April2024._03_Spacecrafts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LaunchPad {

    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();

    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (this.spacecrafts.size() < this.capacity) {
            this.spacecrafts.add(spacecraft);

        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

    public boolean removeSpacecraft(String name) {
        return spacecrafts.removeIf(spacecrafts -> spacecrafts.getName().equals(name));
    }

    public String getHeaviestSpacecraft() {
        Spacecraft heaviestSpacecraft = Collections.max(spacecrafts, Comparator.comparing(Spacecraft::getWeight));
        return String.format("%s - %dkg.", heaviestSpacecraft.getName(), heaviestSpacecraft.getWeight());
    }

    public Spacecraft getSpacecraft(String name) {
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getName().equals(name)) {
                return spacecraft;
            }
        }
        return null;
    }

    public int getCount() {
        return this.spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {

        List<Spacecraft> spacecraftsByMissionType = spacecrafts.stream().filter(spacecraft -> spacecraft.getMissionType().equals(missionType)).toList();

        if (spacecraftsByMissionType.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return spacecraftsByMissionType;
    }

    public String getStatistics() {

        StringBuilder builder = new StringBuilder();
        String launchPadOutput = String.format("Spacecrafts launched from %s:", this.name);
        builder.append(launchPadOutput).append(System.lineSeparator());

        if (spacecrafts.isEmpty()) {
            builder.append("none");

        } else {
            int spacecraftCounter = 1;

            for (Spacecraft spacecraft : spacecrafts) {
                String spacecraftOutput = String.format("%d. %s", spacecraftCounter, spacecraft.getName());
                builder.append(spacecraftOutput).append(System.lineSeparator());
                spacecraftCounter++;
            }
        }
        return builder.toString().trim();
    }
}

