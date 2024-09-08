package _03_DefiningClasses03._02_Exercise._02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt(scanner.nextLine()); // броят на редовете

        Map<String, List<Employee>> departments = new HashMap<>(); //Име на отдела -> списък на служителите

        for (int i = 0; i < n; i++) {
            String employeeInformation = scanner.nextLine(); // информация за служител
            String [] parameters = employeeInformation.split("\\s+"); // в масива държим нашите параметри

            String name = parameters[0];
            double salary = Double.parseDouble(parameters[1]);
            String position = parameters[2];
            String department = parameters[3];

            Employee employee = null; // не се знае по кой конструктор е и с колко параметъра ще бъде

            if (parameters.length == 6){ // ако нашите параметри са равни на 6
                String email = parameters[4];
                int age = Integer.parseInt(parameters[5]);
                employee = new Employee(name, salary, position, department, email, age);

            } else if (parameters.length == 4) { // ако нашите параметри са равни на 4
                employee = new Employee(name, salary, position, department);

            } else if (parameters.length == 5) { // ако нашите параметри са равни на 5
                String forthParameter = parameters[4]; //получаваме (email, age)

            if (forthParameter.contains("@")){ // проверяваме дали е email
                String email = forthParameter;
                employee = new Employee(name, salary, position, department, email);

            }else {
                int age = Integer.parseInt(forthParameter);
                employee = new Employee(name, salary, position, department, age);
            }
          }
            // имаме служител, на който знаем отдела

            if (!departments.containsKey(department)){ // отдела на служителя да го няма
                 departments.put(department, new ArrayList<>()); // отдел -> празен списък
                 departments.get(department).add(employee); // към списъка добавяме служителя

            }else { // отдела на служителя да го има
                departments.get(department).add(employee); // към списъка добавяме служителя
            }
        }
        // до тук имаме: отдела -> списък със служителите

        // кой е отдела с най-висока средна заплата
        String maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);

        List <Employee> employeeList = departments.get(maxAverageSalaryDepartment); // списък с хората от отдела с най-висока заплата
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary())); // ascending order по заплата
        Collections.reverse(employeeList); // descending order по заплата

        for (Employee employee: employeeList) {
            System.out.println(employee);
        }
    }

    public static double getAverageSalary (List<Employee>employees){

        double sum = 0; // сумата от заплатите

        for (Employee employee: employees) { // обхождаме в списъка със служителите всеки служител
             sum += employee.getSalary(); // към общата сума прибавяме заплатата на служителя
        }
        return sum / employees.size(); // сумата от заплатата / броят на служителите
    }
}
