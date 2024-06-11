package Exams._11_JavaAdvancedRetakeExam18August2022._03_ElephantSanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(data -> data.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : this.data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparing(Elephant::getAge)).orElse(null);
    }
    public int getAllElephants () {
        return this.data.size();
    }
    public String getReport() {
        StringBuilder text = new StringBuilder();
        text.append("Saved elephants in the park").append(":").append(System.lineSeparator());

        for (Elephant elephant : data) {
            text.append(String.format("%s came from: %s", elephant.getName(), elephant.getRetiredFrom()))
                    .append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
