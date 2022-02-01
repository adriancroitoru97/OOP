package lab11.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static <T extends Summable> Summable sumAll(Collection<T> elements) {
        T sum = null;

        for (T current : elements) {
            if (sum == null) {
                sum = current;
            } else {
                sum.addValue(current);
            }
        }

        return sum;
    }

    public static void main(final String[] args) {
        /* ------------------------ MyMatrix ------------------------ */

        MyMatrix myMatrix1 = new MyMatrix();
        MyMatrix myMatrix2 = new MyMatrix();
        MyMatrix myMatrix3 = new MyMatrix();

        int[][] m1 = {{1,2,3,4}, {2,3,4,5}, {3,4,5,6}, {4,5,6,7}};
        int[][] m2 = {{5,4,3,2}, {4,3,2,1}, {3,2,1,0}, {2,1,0,-1}};
        int[][] m3 = {{3,3,3,3}, {3,3,3,3}, {3,3,3,3}, {3,3,3,3}};
        myMatrix1.setMatrix(m1);
        myMatrix2.setMatrix(m2);
        myMatrix3.setMatrix(m3);

        List<MyMatrix> matrixList = Arrays.asList(myMatrix1, myMatrix2, myMatrix3);

        System.out.println(Arrays.deepToString(((MyMatrix) sumAll(matrixList)).getMatrix()));


        /* ------------------------ MyVector3 ------------------------ */
        MyVector3 myVector1 = new MyVector3();
        MyVector3 myVector2 = new MyVector3();
        MyVector3 myVector3 = new MyVector3();

        myVector1.setX(1);
        myVector2.setX(2);
        myVector3.setX(6);

        myVector1.setY(7);
        myVector2.setY(5);
        myVector3.setY(9);

        myVector1.setZ(690);
        myVector2.setZ(90);
        myVector3.setZ(96);

        List<MyVector3> vectorList = Arrays.asList(myVector1, myVector2, myVector3);

        System.out.println(sumAll(vectorList));
    }
}
