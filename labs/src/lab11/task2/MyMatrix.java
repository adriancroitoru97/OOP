package lab11.task2;

import java.util.Arrays;

public class MyMatrix implements Summable{
    private int[][] matrix = new int[4][4];

    @Override
    public void addValue(Summable value) {
        if (value instanceof MyMatrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] += ((MyMatrix)value).matrix[i][j];
                }
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return "MyMatrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
