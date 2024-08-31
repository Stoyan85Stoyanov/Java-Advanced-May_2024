package Exams._07_JavaAdvancedRetakeExam12April2023.magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private String type;
    private int capacity;
    List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Cloth> getData() {
        return data;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setData(List<Cloth> data) {
        this.data = data;
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < this.capacity) {
            this.data.add(cloth);
        }
    }
    public boolean removeCloth(String color) {
        return data.removeIf(registry -> registry.getColor().equals(color));
    }
    public Cloth getSmallestCloth() {
        return this.data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);
    }
    public Cloth getCloth(String color) {
        for (Cloth cloth : this.data) {
            if (cloth.getColor().equals(color)) {
                return cloth;
            }
        }
        return null;
    }
    public int getCount() {
        return this.data.size();
    }
    public String report() {
        StringBuilder text = new StringBuilder();
        text.append(String.format("%s magazine contains", type)).append(":").append(System.lineSeparator());

        for (Cloth cloth : data) {
            text.append(cloth.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}