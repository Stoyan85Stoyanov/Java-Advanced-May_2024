package _03_DefiningClasses03._02_Exercise._01_OpinionPoll;

public class Person {

    // ще държим в този клас характеристиките на този човек - име и възраст
    // Създайте клас Person с две полета String name и int age.
    private String name; // private достъпно само за съоветния клас между {} скоби
    private  int age;

    // конструктор - служи за създаване на обекти от съответния клас
      public Person (String name, int age) { // приема (String name, int age)
          this.name = name;
          this.age = age;

      }
      // getter -- достъп до това поле (връща стойността на полето name)
      public String getName (){
          return name;
      }
    // getter -- достъп до това поле (връща стойността на полето age)
      public int getAge () {
          return age;
      }
      @Override
      public String toString () {
          return name + " - " + age;
      }
}
