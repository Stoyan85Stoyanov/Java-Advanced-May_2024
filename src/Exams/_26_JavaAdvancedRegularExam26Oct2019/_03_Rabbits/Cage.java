package Exams._26_JavaAdvancedRegularExam26Oct2019._03_Rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public Rabbit removeSpecies(String species) {
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                removeRabbit(species);
            }
        }
        return null;
    }


    public Rabbit sellRabbit(String name) {

        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species)  {

        List<Rabbit> soldRabbits = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                rabbit.setAvailable(false);
                soldRabbits.add(rabbit);
            }
        }
        return soldRabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        String firstLine = String.format("Rabbits available at %s:", this.name);
        sb.append(firstLine).append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()) {
                sb.append(rabbit.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
