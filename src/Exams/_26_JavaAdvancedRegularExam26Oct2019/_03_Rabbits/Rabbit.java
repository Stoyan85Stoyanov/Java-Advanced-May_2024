package Exams._26_JavaAdvancedRegularExam26Oct2019._03_Rabbits;

public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species) {  // constructor
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() { // гетъри
        return name;
    }

    public String getSpecies() { // гетъри
        return species;
    }
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return String.format("Rabbit (%s): %s", this.species, this.name);
    }
}
