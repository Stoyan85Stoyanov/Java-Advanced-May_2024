package Exams._08_JavaAdvancedRegularExam18February2023._03_SoftUniKindergarten;

public class Child {
    private String firstName;
    private String lastName;
    private int age;
    private String parentName;
    private String contactNumber;

    public Child(String firstName, String lastName, int age, String parentName, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.parentName = parentName;
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getParentName() {
        return parentName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String toString() {
        return String.format("Child: %s %s, Age: %d, Contact info: %s - %s", this.firstName, this.lastName, this.age, this.parentName, this.contactNumber);
    }
}

