package Exams._06_JavaAdvancedRetakeExam9August2023.vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getButtonCapacity() {
        return buttonCapacity;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setButtonCapacity(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < this.buttonCapacity) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        return drinks.removeIf(drink -> drink.getName().equals(name));
    }

    public Drink getLongest() {
        return this.drinks.stream().max(Comparator.comparing(Drink::getVolume)).orElse(null);
    }

    public Drink getCheapest() {
        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }

    public String buyDrink(String name) {
        Optional<Drink> drink = this.drinks.stream().filter(d -> d.getName().equals(name)).findFirst();
        return drink.map(value -> value.toString().trim()).orElse("");
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        text.append("Drinks available").append(":").append(System.lineSeparator());

        for (Drink drink : drinks) {
            text.append(drink.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
