package Exams._19_JavaAdvancedRetakeExam14April2021._03_University;

import java.util.ArrayList;
import java.util.List;

public class University {

     public int capacity;
     public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }
    public int getStudentCount() {
        return this.students.size();
    }
    public String registerStudent(Student student) {
        StringBuilder text = new StringBuilder();

        if (this.students.size() < capacity) {
            if (this.students.contains(student)) {
                text.append("Student is already in the university");

            } else {
                this.students.add(student);
                text.append("Added student ").append(student.getFirstName()).append(" ").append(student.getLastName());
            }

           } else {
                text.append("No seats in the university");
           }

        return text.toString();
    }

    public String dismissStudent(Student student) {
        StringBuilder text = new StringBuilder();

        if (this.students.contains(student)) {
            text.append("Removed student ").append(student.getFirstName()).append(" ").append(student.getLastName());
            this.students.remove(student);

        } else {
            text.append("Student not found");

        }
        return text.toString();
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students
                .stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        this.students.forEach(student -> text.append("==Student: First Name = ").append(student.getFirstName())
                .append(", Last Name = ").append(student.getLastName()).append(", Best Subject = ")
                .append(student.getBestSubject()).append(System.lineSeparator()));

        return text.toString().trim();
    }
}
