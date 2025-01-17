package Exams._19_JavaAdvancedRetakeExam14April2021._03_University;

public class Student {
     public String firstName;
     public String lastName;
     public String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBestSubject(String bestSubject) {
        this.bestSubject = bestSubject;
    }

    public String toString () {
        return String.format("Student: %s %s, %s", this.firstName, this.lastName, this.bestSubject );
    }
}

