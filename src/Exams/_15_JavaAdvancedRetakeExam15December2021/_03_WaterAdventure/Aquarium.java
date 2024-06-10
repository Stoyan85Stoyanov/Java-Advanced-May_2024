package Exams._15_JavaAdvancedRetakeExam15December2021._03_WaterAdventure;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;


    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();

    }
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.fishInPool.size() < this.capacity) {
            this.fishInPool.add(fish);
        }
    }
    public boolean remove(String name) {
        return fishInPool.removeIf(person -> person.getName().equals(name));
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }
    public String report() {
        StringBuilder text = new StringBuilder();
        text.append("Aquarium: ").append(this.name).append(" ^ Size: ").append(this.size).append(System.lineSeparator());

        for (Fish fish : fishInPool) {
            text.append(fish.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
