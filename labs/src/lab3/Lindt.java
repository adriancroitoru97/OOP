package lab3;

public class Lindt extends CandyBox {
    private float length;
    private float width;
    private float height;

    public Lindt() {
        this("Standard", "Standard", 1, 1, 1);
    }

    public Lindt(String flavor, String origin,
                 float length, float width, float height) {
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    float getVolume() {
        return this.height * this.length * this.width;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() + " " +
                this.getFlavor() + " has volume " +
                this.getVolume();
    }

    void printLindtDim() {
        System.out.println("Length: " + length + ", " + "Width: " + width +
                           " and " + "Height: " + height);
    }

    void printCandy() {
        System.out.println(this);
    }
}
