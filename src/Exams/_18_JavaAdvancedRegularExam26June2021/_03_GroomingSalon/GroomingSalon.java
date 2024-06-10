package Exams._18_JavaAdvancedRegularExam26June2021._03_GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(pet -> pet.getName().equals(name)
                && pet.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append("The grooming salon has the following clients").append(":").append(System.lineSeparator());
        for (Pet pet : data) {
            text.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
