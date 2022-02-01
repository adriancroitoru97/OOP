package lab3;

public class Main {
    public static void main(String[] args) {
        /* Test tasks 1 & 2 */
        CandyBox candyBox1 = new CandyBox("Cioco", "Romania");
        CandyBox lindt1 = new Lindt("Cacao1", "Venezuela1", 5, 3, 2);
        CandyBox lindt2 = new Lindt("Cacao2", "Venezuela2", 10, 3, 1);
        CandyBox lindt3 = new Lindt("Cacao3", "Venezuela3", 5, 5, 8);

        System.out.println(candyBox1);
        System.out.println(lindt1);

        /* Test task 3 */
        System.out.println(lindt1.equals(lindt2));
        System.out.println(lindt1.equals(lindt3));

        /* Test task 4 */
        CandyBag candyBag = new CandyBag();

        CandyBox candy1 = new Lindt("Cacao", "Venezuela", 5, 3, 2);
        CandyBox candy2 = new Lindt("Caramel", "Belgium", 3, 3, 3);
        CandyBox candy3 = new Baravelli("Cocos", "Belgium", 4, 10);
        CandyBox candy4 = new ChocAmor("Mint", "Cuba", 2);
        candyBag.getBag().add(candy1);
        candyBag.getBag().add(candy2);
        candyBag.getBag().add(candy3);
        candyBag.getBag().add(candy4);

        System.out.println(candyBag);

        /* Test task 5 */
        Lindt lindtCast = (Lindt) candy1;
        Baravelli baravelliCast = (Baravelli) candy3;
        ChocAmor chocAmorCast = (ChocAmor) candy4;

        baravelliCast.printBaravelliDim();
        lindtCast.printLindtDim();
        chocAmorCast.printChocAmorDim();

        /* Test task 6 */
        Area area = new Area(candyBag, 28, "Iuliu Maniu");
        area.getBirthdayCard();
    }
}
