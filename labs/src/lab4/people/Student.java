package lab4.people;

import lab4.database.Database;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String firstName;
    private String lastName;
    private Map<String, Integer> subjects;

    public Student(String firstName, String lastName, Map<String, Integer> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    public Student(Student student) {
        this.firstName = student.firstName;
        this.lastName = student.lastName;
        this.subjects = new HashMap<>(student.subjects);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashMap<String, Integer> subjects) {
        this.subjects = subjects;
    }

    public double averageGrade() {
        float totalSum = 0;
        for (Integer value : subjects.values()) {
            totalSum += value;
        }

        return totalSum / this.subjects.size();
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> deepCopy = new ArrayList<>();
        for (var teacher: lab4.database.Database.getDatabase().findAllTeachers()) {
            deepCopy.add(new Teacher(teacher));
        }

        return deepCopy;
    }

    public int getGradeForSubject(String subject) {
        return subjects.get(subject);
    }

    @Override
    public String toString() {
        return "Student: " + firstName + " " + lastName + "\n"
                + "Subjects: " + subjects + "\n";
    }

    public List<Teacher> getTeachersBySubject(String subject) {
        List<Teacher> deepCopy = new ArrayList<>();
        for (var teacher: lab4.database.Database.getDatabase().findTeachersBySubject(subject)) {
            deepCopy.add(new Teacher(teacher));
        }

        return deepCopy;
    }

    public List<Student> getAllStudents() {
        List<Student> deepCopy = new ArrayList<>();
        for (var student: lab4.database.Database.getDatabase().findAllStudents()) {
            deepCopy.add(new Student(student));
        }

        return deepCopy;
    }

    public List<Student> getStudentsBySubject(String subject) {
        List<Student> deepCopy = new ArrayList<>();
        for (var student: lab4.database.Database.getDatabase().getStudentsBySubject(subject)) {
            deepCopy.add(new Student(student));
        }

        return deepCopy;
    }

    public List<Student> getStudentsByAverageGrade() {
        List<Student> deepCopy = new ArrayList<>();
        for (var student: lab4.database.Database.getDatabase().getStudentsByAverageGrade()) {
            deepCopy.add(new Student(student));
        }

        return deepCopy;
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        List<Student> deepCopy = new ArrayList<>();
        for (var student: lab4.database.Database.getDatabase().getStudentsByGradeForSubject(subject)) {
            deepCopy.add(new Student(student));
        }

        return deepCopy;
    }
}
