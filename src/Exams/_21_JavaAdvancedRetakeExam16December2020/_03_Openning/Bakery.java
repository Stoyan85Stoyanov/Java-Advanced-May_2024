package Exams._21_JavaAdvancedRetakeExam16December2020._03_Openning;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }
    public boolean remove(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
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
        text.append("Employees working at Bakery ").append(this.name).append(":").append(System.lineSeparator());

        for (Employee employee : employees) {
            text.append(employee.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }
}
