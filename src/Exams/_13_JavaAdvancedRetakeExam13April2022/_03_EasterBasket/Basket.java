package Exams._13_JavaAdvancedRetakeExam13April2022._03_EasterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return data.removeIf(employee -> employee.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }
    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        text.append(this.material).append(" basket contains:").append(System.lineSeparator());

        for (Egg egg : data) {
            text.append(egg.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
