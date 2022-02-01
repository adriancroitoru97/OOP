package lab2.task1;

public class Test {
    public static void main(String[] args) {
        Complex c1, c2, c3;
        c1 = new Complex(5, 3);
        c2 = new Complex();
        c3 = new Complex(c1);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        c3.addWithComplex(c1);
        System.out.println(c3);
        c1.showNumber();
    }
}
