package lab2.task3;

import java.util.Arrays;

public class Polygon {
    private int n;
    private Point[] points;

    public Polygon(int n) {
        this.n = n;
        this.points = new Point[n];
        for (int i = 0; i < n; i++) {
            this.points[i] = new Point(0, 0);
        }
    }

    public Polygon(float[] v) {
        this(v.length / 2);
        for (int i = 0; i < v.length / 2; i++) {
            this.points[i].changeCoords(v[2 * i], v[2 * i + 1]);
        }
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "n=" + n +
                ", points=" + Arrays.toString(points) +
                '}';
    }
}
