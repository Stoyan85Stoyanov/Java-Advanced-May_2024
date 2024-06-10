package Exams._16_JavaAdvancedRegularExam23October2021._03_Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }
    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }
    public boolean remove(String name) {
        return roster.removeIf(person -> person.getName().equals(name));
    }
    public Person getPerson(String name, String hometown) {
        return this.roster.stream().filter(person -> person.getName().equals(name)
                && person.getHometown().equals(hometown)).findFirst().orElse(null);
    }
    public int getCount() {
        return this.roster.size();
    }
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append("The people in the hotel ").append(this.name).append(" are:").append(System.lineSeparator());
        for (Person roster : roster) {
            text.append(roster.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
