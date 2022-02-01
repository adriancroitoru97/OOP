package lab3;

public class ChocAmor extends CandyBox {
    private float length;

    public ChocAmor() {
        this("Standard", "Standard", 1);
    }

    public ChocAmor(String flavor, String origin,
                    float length) {
        super(flavor, origin);
        this.length = length;
    }

    @Override
    float getVolume() {
        return this.length * this.length * this.length;
    }

    @Override
    public String toString() {
        return "The " + this.getOrigin() + " " +
                this.getFlavor() + " has volume " +
                this.getVolume();
    }

    void printChocAmorDim() {
        System.out.println("Length: " + length);
    }

    void printCandy() {
        System.out.println(this);
    }
}
