package lab4.people;

import lab4.database.Database;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String firstName;
    private String lastName;
    private List<String> subjects;

    public Teacher(String firstName, String lastName, List<String> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    public Teacher (Teacher teacher) {
        this.firstName = teacher.firstName;
        this.lastName = teacher.lastName;
        this.subjects = new ArrayList<>(teacher.subjects);
    }

    @Override
    public String toString() {
        return "Teacher: " + firstName + " " + lastName + "\n"
                + "Subjects: " + subjects + "\n";
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

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<Teacher> getAllTeachers() {
        return lab4.database.Database.getDatabase().findAllTeachers();
    }

    public List<Teacher> getTeachersBySubject(String subject) {
        return lab4.database.Database.getDatabase().findTeachersBySubject(subject);
    }

    public List<Student> getAllStudents() {
        return lab4.database.Database.getDatabase().findAllStudents();
    }

    public List<Student> getStudentsBySubject(String subject) {
        return lab4.database.Database.getDatabase().getStudentsBySubject(subject);
    }

    public List<Student> getStudentsByAverageGrade() {
        return lab4.database.Database.getDatabase().getStudentsByAverageGrade();
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        return lab4.database.Database.getDatabase().getStudentsByGradeForSubject(subject);
    }
}
