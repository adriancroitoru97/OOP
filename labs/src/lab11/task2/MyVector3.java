package lab11.task2;

public class MyVector3 implements Summable{
    private int x;
    private int y;
    private int z;

    @Override
    public void addValue(Summable value) {
        if (value instanceof MyVector3) {
            x += ((MyVector3)value).x;
            y += ((MyVector3)value).y;
            z += ((MyVector3)value).z;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "MyVector3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
