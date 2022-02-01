package lab1.task2;

public class Task3 {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student();

        st1.setName("George");
        st2.setName("George");
        st1.setYear(2020);
        st2.setYear(2020);

        System.out.println(st1.equals(st2));
    }
}
