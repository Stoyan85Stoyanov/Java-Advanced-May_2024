package Exams._04_JavaAdvancedRegularExam21October2023.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Kid> getData() {
        return data;
    }
    public void addKid(Kid kid) { // добавя обект към данните, ако има празно място за детето
        if (data.size() < capacity) {
            data.add(kid);
        }
    }
    public boolean removeKid(String name) { // премахва детето по дадено име, ако съществува такова, и връща булево.
        return data.removeIf(k -> k.getName().equals(name));
    }
    public Kid getKid(String street) {
        return data.stream()
                .filter(k -> k.getStreet().equals(street))
                .findFirst()
                .orElse(null);
    }
    public int getAllKids() { // връща броя на децата
        return this.data.size();
    }
    public String getStatistics(){

        StringBuilder builder = new StringBuilder();
        builder.append("Children who visited a house for candy:");
        builder.append(System.lineSeparator());
        data.forEach(kid -> builder.append(String.format("%s from %s street", kid.getName(), kid.getStreet())).append(System.lineSeparator()));

        return builder.toString().trim();
    }
}
