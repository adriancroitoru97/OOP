package lab3;

public class Area {
    private CandyBag candyBag;
    private int number;
    private String street;

    public Area() {}

    public Area(CandyBag candyBag, int number, String street) {
        this.candyBag = candyBag;
        this.number = number;
        this.street = street;
    }

    void getBirthdayCard() {
        System.out.println("Str. " + street + ", nr." + number);
        System.out.println("La multi ani fericiti!");

        for (int i = 0; i < candyBag.getBag().size(); i++) {
            System.out.println(candyBag.getBag().get(i));
        }

        for (int i = 0; i < candyBag.getBag().size(); i++) {
            candyBag.getBag().get(i).printCandy();
        }
    }

}
