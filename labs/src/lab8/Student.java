package lab8;

public class Student implements Comparable<Student> {
    private final String name;
    private final String surname;
    private final long id;
    private final double averageGrade;


    public Student(String name, String surname, long id, double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(Student o) {
        if (averageGrade == o.averageGrade) {
            if (surname.equals(o.surname)) {
                return name.compareTo(o.name);
            } else {
                return surname.compareTo(o.surname);
            }
        } else {
            if (averageGrade > o.averageGrade) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", averageGrade=" + averageGrade +
                "}\n";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
