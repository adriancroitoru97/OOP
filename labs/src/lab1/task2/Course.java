package lab1.task2;

public class Course {
    private String title;
    private String description;
    private Student[] students;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Student[] getStudents() {
        return students;
    }

    public Student[] filterYear(int year) {
        int numberOfFilteredStudents = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getYear() == year) {
                numberOfFilteredStudents++;
            }
        }

        Student[] studentsFiltered = new Student[numberOfFilteredStudents];
        int index = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i].getYear() == year) {
                studentsFiltered[index++] = students[i];
            }
        }

        return studentsFiltered;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
