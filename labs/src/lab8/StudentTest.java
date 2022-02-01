package lab8;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class StudentTest {

    private Student student;

    @BeforeEach
    private void setUp() {
        student = new Student("Adrian", "Croitoru", 1, 10);
    }

    @AfterEach
    private void cleanUp() {
        student = null;
    }

    @Test
    @DisplayName("CompareTo test")
    public void testCompareTo() {
        Student student2 = new Student("Adrian", "Croitoru", 1, 10);
        Student student3 = new Student("Ianis", "Hagi", 1, 8);
        Student student4 = new Student("Andrei", "Croitoru", 1, 10);
        Assertions.assertEquals(0, student.compareTo(student2));
        Assertions.assertTrue(student.compareTo(student4) < 0);
        Assertions.assertTrue(student.compareTo(student3) > 0);
    }
}
