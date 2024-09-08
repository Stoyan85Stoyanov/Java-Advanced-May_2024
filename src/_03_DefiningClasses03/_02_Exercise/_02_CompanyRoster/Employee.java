package _03_DefiningClasses03._02_Exercise._02_CompanyRoster;

public class Employee {
    // имаме следните характеристики: name, salary, position, department, email, and age
    // задължителни
    private String name;
    private double salary;
    private String position;
    private String department;
    // по избор
    private String email;
    private int age;

    public Employee (String name, double salary, String position, String department){  // конструктор
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }
    public Employee (String name, double salary, String position, String department, String email, int age){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }
    public Employee (String name, double salary, String position, String department, String email){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = -1;

    }
    public Employee (String name, double salary, String position, String department, int age){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
        this.email = "n/a";
    }
    // getter на полето salary
    public double getSalary () {
        return salary;
    }
    @Override // преработваме toString
    public String toString (){
        StringBuilder builder = new StringBuilder();
        builder.append(name + " ").append(String.format("%.2f",salary) + " ");

        if (email != null){  // ако имаме email
            builder.append(email + " ");

        }else {
            builder.append("n/a ");
        }

        if (age == 0) { // ако нямаме age
            builder.append("-1");

        }else {
            builder.append(age);
        }
        return builder.toString();
    }
}
