package lab4.database;

import lab4.people.Student;
import lab4.people.Teacher;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Database {
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private static int noOfInstances = 0;

    private static Database instance = null;

    private Database() {}

    public static Database getDatabase() {
        if (instance == null) {
            instance = new Database();
            noOfInstances++;
        }
        return instance;
    }

    public static int getNumberOfInstances() {
        return noOfInstances;
    }

    public void addTeachers(List<Teacher> teachers) {
        this.teachers.addAll(teachers);
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public List<Teacher> findTeachersBySubject(String subject) {
        List<Teacher> teachersWithSubject = new ArrayList<>();
        for (Teacher actual : this.teachers) {
            if (actual.getSubjects().contains(subject)) {
                teachersWithSubject.add(actual);
            }
        }

        return teachersWithSubject;
    }

    public List<Student> findAllStudents() {
        return this.students;
    }

    public List<Teacher> findAllTeachers() {
        return this.teachers;
    }

    public List<Student> getStudentsBySubject(String subject) {
        List<Student> studentsWithSubject = new ArrayList<>();
        for (Student actual : this.students) {
            if (actual.getSubjects().containsKey(subject)) {
                studentsWithSubject.add(actual);
            }
        }

        return studentsWithSubject;
    }

    public List<Student> getStudentsByAverageGrade() {
        List<Student> studentsByAverageGrade = new ArrayList<>(this.students);
        studentsByAverageGrade.sort(Comparator.comparingDouble(Student::averageGrade));

        return studentsByAverageGrade;
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        List<Student> studentsByAverageGradeForSubject = new ArrayList<>(getStudentsBySubject(subject));
        studentsByAverageGradeForSubject.sort(Comparator.comparingDouble(Student::averageGrade));

        return studentsByAverageGradeForSubject;
    }
}
