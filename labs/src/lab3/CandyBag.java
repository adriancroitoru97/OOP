package lab3;

import java.util.ArrayList;

public class CandyBag {
    private ArrayList<CandyBox> bag = new ArrayList<>();

    @Override
    public String toString() {
        return "CandyBag{" +
                "bag=" + bag +
                '}';
    }

    public ArrayList<CandyBox> getBag() {
        return bag;
    }

    public void setBag(ArrayList<CandyBox> bag) {
        this.bag = bag;
    }
}
