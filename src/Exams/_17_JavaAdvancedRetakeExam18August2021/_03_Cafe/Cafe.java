package Exams._17_JavaAdvancedRetakeExam18August2021._03_Cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee (Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return employees.removeIf(pet -> pet.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
    public int getCount () {
        return this.employees.size();
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        text.append("Employees working at Cafe ").append(this.name).append(":").append(System.lineSeparator());

        for (Employee employee : employees) {
            text.append(employee.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
