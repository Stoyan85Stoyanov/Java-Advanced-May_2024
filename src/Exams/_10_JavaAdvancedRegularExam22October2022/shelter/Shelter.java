package Exams._10_JavaAdvancedRegularExam22October2022.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Animal> getData() {
        return data;
    }

    public void add(Animal animal) {
        if (this.data.size() < this.capacity) {
            this.data.add(animal);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(animal -> animal.getName().equals(name));
    }
    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream().filter(animal -> animal.getName().equals(name)
                && animal.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }
    public Animal getOldestAnimal() {
        return this.data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }
    public int getCount () {
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder builder = new StringBuilder();

        builder.append("The shelter has the following animals:");
        for (Animal animal : data) {
            builder.append(System.lineSeparator());
            builder.append(animal.getName());
            builder.append(" ");
            builder.append(animal.getCaretaker());
        }

        return builder.toString().trim();
    }
}
