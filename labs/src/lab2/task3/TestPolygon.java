package lab2.task3;

public class TestPolygon {
    public static void main(String[] args) {
        float[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Polygon polygon1 = new Polygon(5);
        Polygon polygon2 = new Polygon(points);

        System.out.println(polygon1);
        System.out.println(polygon2);
    }
}
