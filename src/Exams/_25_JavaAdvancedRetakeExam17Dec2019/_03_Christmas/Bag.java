package Exams._25_JavaAdvancedRetakeExam17Dec2019._03_Christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {

     private String color;
     private int capacity;
     private List <Present> data;


    public Bag (String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
         return color;
     }
     public int getCapacity () {
         return capacity;
     }
    public int count() {
        return this.data.size();
    }
    public void add(Present present) {
        if (this.data.size() < capacity) {
            this.data.add(present);
        }
    }
    public boolean remove(String name) {
        return this.data.removeIf(bag -> bag.getName().equals(name));
    }
    public Present heaviestPresent() {
        Present present = null;
        for (Present p : this.data) {
            if (present==null){
              present=p;
            }else if (p.getWeight() > present.getWeight()) {
                present = p ;
            }
        }
        return present;
    }

    public Present getPresent(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        String firstLine = String.format("%s bag contains:", this.color);
        sb.append(firstLine).append(System.lineSeparator());
        for (Present present : this.data) {
                sb.append(present.toString()).append(System.lineSeparator());
            
        }
        return sb.toString();
    }
}
