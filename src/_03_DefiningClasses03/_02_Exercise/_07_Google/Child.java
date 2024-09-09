package _03_DefiningClasses03._02_Exercise._07_Google;

public class Child {

    private String childName;
    private String childBirthday;

    public Child(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
      return  childName + " " + childBirthday;
    }
}
