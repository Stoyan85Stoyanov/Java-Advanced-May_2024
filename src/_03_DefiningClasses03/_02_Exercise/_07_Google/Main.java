package _03_DefiningClasses03._02_Exercise._07_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String information = scanner.nextLine(); // въвеждаме информация докато не поучим командата End
        Map<String, Person>peopleData = new HashMap<>(); // името на човека -> неговите данни

        while (!information.equals("End")) {
            String [] parameters = information.split("\\s+"); // държим (съхраняваме) нашите команди
            String personName = parameters [0]; // името на човека

            if (!peopleData.containsKey(personName)){ //правим проверка дали човека го има в списъка
                peopleData.put(personName, new Person()); // добавяме човека в празния списък
            }
            String typeCommand = parameters [1]; // типа на командата

            switch (typeCommand){
                case "company":
                    String companyName = parameters [2];
                    String department = parameters [3];
                    double salary = Double.parseDouble(parameters [4]);
                    Company company = new Company(companyName, department, salary);//създаваме компания
                    peopleData.get(personName).setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = parameters [2];
                    String pokemonType = parameters [3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType); // създаваме покемон
                    peopleData.get(personName).getPokemons().add(pokemon);
                    break;

                case "parents":
                    String parentName = parameters [2];
                    String parentBirthday = parameters [3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    peopleData.get(personName).getParents().add(parent);
                    break;

                case "children":
                    String childName = parameters [2];
                    String childBirthday = parameters [3];
                    Child child = new Child(childName, childBirthday);
                    peopleData.get(personName).getChildren().add(child);
                    break;

                case "car":
                    String carModel = parameters [2];
                    int carSpeed = Integer.parseInt(parameters [3]);
                    Car car = new Car(carModel,carSpeed);
                    peopleData.get(personName).setCar(car);
                    break;
            }
             information = scanner.nextLine();
        }
        String searchedPerson = scanner.nextLine(); // въвеждаме името на търсения човек
        System.out.println(searchedPerson);

        // данните за човека
        Person personalData = peopleData.get(searchedPerson); // от мапа взимаме данните за въпросният човек
        System.out.println(personalData);
    }
}
