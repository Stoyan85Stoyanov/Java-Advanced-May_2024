package _006_DefiningClasses._02_Exercise._07_Google;

public class Parent {

    private String parentName;
    private String parentBirthday;


    public Parent(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return parentName + " " + parentBirthday;
    }
}
