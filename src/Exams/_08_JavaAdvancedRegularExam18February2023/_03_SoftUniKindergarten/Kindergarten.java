package Exams._08_JavaAdvancedRegularExam18February2023._03_SoftUniKindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.getChildrenCount() == this.capacity) {
            return false;
        }
        this.registry.add(child);
        return true;
    }

    public boolean removeChild(String firstName) {
        return registry.removeIf(registry -> registry.getFirstName().equals(firstName));
    }

    public int getChildrenCount () {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }
        return null;
    }

    public String registryReport() {
        List<Child> sortedChildren = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName))
                .toList();

        StringBuilder builder = new StringBuilder();
        builder.append("Registered children in ").append(this.name).append(":");

        for (Child child : sortedChildren) {
            builder.append(System.lineSeparator()).append("--").append(System.lineSeparator());
            builder.append(child.toString());
        }

        return builder.toString().trim();
    }
}
