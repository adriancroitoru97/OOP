package lab3;

public class Baravelli extends CandyBox {
    private float radius;
    private float height;

    public Baravelli() {
        this("Standard", "Standard", 1, 1);
    }

    public Baravelli(String flavor, String origin,
                     float radius, float height) {
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    float getVolume() {
        return (float)Math.PI * this.radius * this.radius * this.height;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() + " " +
                this.getFlavor() + " has volume " +
                this.getVolume();
    }

    void printBaravelliDim() {
        System.out.println("Radius: " + radius + " and " +"Height: " + height);
    }

    void printCandy() {
        System.out.println(this);
    }
}
