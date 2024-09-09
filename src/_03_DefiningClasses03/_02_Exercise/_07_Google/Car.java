package _03_DefiningClasses03._02_Exercise._07_Google;

public class Car {
       // характеристики на колата
       private String carModel;
       private int carSpeed;

       // конструктор
       public Car (String carModel, int carSpeed) {
           this.carModel = carModel;
           this.carSpeed = carSpeed;
       }
       @Override
       public String toString () {
           return  carModel + " " + carSpeed;
       }
}
