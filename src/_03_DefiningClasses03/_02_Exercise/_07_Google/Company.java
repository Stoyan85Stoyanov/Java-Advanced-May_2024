package _03_DefiningClasses03._02_Exercise._07_Google;

public class Company {

    private String companyName;
    private String department;
    private double salary;

    public Company (String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString () {
        return companyName + " " + department + " " + String.format("%.2f", salary);
    }
}
