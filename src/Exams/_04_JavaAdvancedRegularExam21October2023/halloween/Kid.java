package Exams._04_JavaAdvancedRegularExam21October2023.halloween;

public class Kid {
    private String name;
    private int age;
    private String street;

    public Kid(String name, int age, String street) {
        this.name = name;
        this.age = age;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return String.format("%s, %d years old, from %s", name, age, street);
    }
}
