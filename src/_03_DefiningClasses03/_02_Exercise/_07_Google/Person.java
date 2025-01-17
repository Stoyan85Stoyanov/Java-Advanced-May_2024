package _03_DefiningClasses03._02_Exercise._07_Google;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Person {

    // Има в него включени (име, 1 компания, 1 кола, списък с родители, списък с деца, списък с покемони)
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person() {  // празен обект (данни за човека)
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Person(Company company, Car car, List<Parent> parents, List<Child> children, List<Pokemon> pokemons) {
        this.company = company;
        this.car = car;
        this.parents = parents;
        this.children = children;
        this.pokemons = pokemons;
    }

    public void setCompany(Company company) { //setter
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company).append("\n");
        }
        builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car).append("\n");
        }
        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon: pokemons) {
            builder.append(pokemon).append("\n");
        }
        builder.append("Parents:").append("\n");
        for (Parent parents: parents) {
            builder.append(parents).append("\n");
        }
        builder.append("Children:").append("\n");
        for (Child children: children) {
            builder.append(children).append("\n");
        }
        return builder.toString();
    }
}
