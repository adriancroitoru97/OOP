package lab8;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student("Adrian", "Croitoru", 1, 10);
        Student student2 = new Student("Daniel", "Vasilescu", 2, 6.90);
        Student student3 = new Student("Vasile", "Canae", 3, 3.90);
        Student student4 = new Student("Darius", "Vasilescu", 4, 6.90);
        Student student5 = new Student("Mihnea", "Vasilache", 5, 6.90);

        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5));



        /* TEST TASK 1 & 2 */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~TASK 1 & 2~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Collections.sort(students);
        System.out.println(students);



        /* TEST TASK 3 */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~TASK 3~~~~~~~~~~~~~~~~~~~~~~~~~~");

        students.sort((s1, s2) -> (int) (s2.getAverageGrade() - s1.getAverageGrade()));
        /* SAU */
        /* students.sort(Comparator.comparing(Student::getAverageGrade).reversed()); */

        System.out.println(students);



        /* TEST TASK 4 */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~TASK 4~~~~~~~~~~~~~~~~~~~~~~~~~~");

        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(Student::getId));
        priorityQueue.addAll(students);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }



        /* TEST TASK 5 */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~TASK 5~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Metodele au fost suprascrise!\n");



        /* TEST TASK 6 */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~TASK 6~~~~~~~~~~~~~~~~~~~~~~~~~~");

        HashMap<Student, LinkedList<String>> hashMap = new HashMap<>();
        hashMap.put(student1, new LinkedList<>(Arrays.asList("POO", "IOCLA")));
        hashMap.put(student2, new LinkedList<>(Arrays.asList("POO", "EEA", "ENGLEZA")));
        hashMap.put(student3, new LinkedList<>(Arrays.asList("M1", "PC", "SD")));
        hashMap.put(student4, new LinkedList<>(Arrays.asList("POO", "FC", "IOCLA")));
        hashMap.put(student5, new LinkedList<>(Arrays.asList("PL", "M1", "M2")));

        for (Map.Entry<Student, LinkedList<String>> entry : hashMap.entrySet()) {
            System.out.println(entry);
        }



        /* TEST TASK 7 */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~TASK 7~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Task7 task7 = new Task7();
        for (int i = 1; i < 10; i++) {
            task7.add(i);
        }

        for (Integer current : task7) {
            System.out.println(current);
        }



        /* TEST TASK 8 */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~TASK 8~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~REZOLVAT SI PE LAMBDA CHECKER~~~~~~~~~~~~~~~");
        System.out.println("Introdu n, iar apoi n numere: ");
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        HashMap<Integer, Integer> hashMap1 = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (hashMap1.containsKey(x)) {
                hashMap1.put(x, hashMap1.get(x) + 1);
            } else {
                hashMap1.put(x, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
            System.out.printf("%d: %d ", entry.getKey(), entry.getValue());
        }

        System.out.println("\n");



        /* TEST TASK 9 */
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~TASK 9~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~Clasa StudentTest a fost creata!~~~~~~~~~~~~~~~");
    }
}
