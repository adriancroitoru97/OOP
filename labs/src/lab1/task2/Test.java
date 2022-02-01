package lab1.task2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);

        Course objectCourse = new Course();
        Student objectStudent1 = new Student();
        Student objectStudent2 = new Student();
        Student objectStudent3 = new Student();
        objectStudent1.setYear(2021); objectStudent1.setName("Silviu");
        objectStudent2.setYear(2004); objectStudent2.setName("Silvian");
        objectStudent3.setYear(2021); objectStudent3.setName("Silvestru");

        Student[] studentArray = new Student[3];
        studentArray[0] = objectStudent1;
        studentArray[1] = objectStudent2;
        studentArray[2] = objectStudent3;

        objectCourse.setTitle("POO");
        objectCourse.setDescription("O materie foarte frumoasa!");
        objectCourse.setStudents(studentArray);

        System.out.println(Arrays.toString(objectCourse.filterYear(year)));
    }
}
