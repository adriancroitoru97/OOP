package lab2.task3;

public class Point {
    private float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    void changeCoords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    void showPoint() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
