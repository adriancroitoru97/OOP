package lab13.task2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO: Initialize the calculator
        Calculator calculator = new MyCalculator();

        System.out.println(calculator.add(2d, 3d));
        System.out.println(calculator.divide(9d, 4d));
        System.out.println(calculator.average(List.of(1d, 2d, 3d, 4d)));

        // TODO: Test edge cases that would throw exceptions
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ADD~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        try {
            System.out.println(calculator.add(null, 3d));
        } catch (Calculator.NullParameterException e) {
            System.out.println("1 - NULL parameters found!");
        }

        try {
            System.out.println(calculator.add(1E308d, 1E308d));
        } catch (Calculator.OverflowException e) {
            System.out.println("2 - Add Overflow!");
        }

        try {
            System.out.println(calculator.add(-1E308d, -1E308d));
        } catch (Calculator.UnderflowException e) {
            System.out.println("3 - Add Underflow!");
        }


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~DIVIDE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        try {
            System.out.println(calculator.divide(null, 3d));
        } catch (Calculator.NullParameterException e) {
            System.out.println("1 - NULL parameters found!");
        }

        try {
            System.out.println(calculator.divide(150d, 0d));
        } catch (Calculator.OverflowException e) {
            System.out.println("2 - Divide Overflow!");
        }

        try {
            System.out.println(calculator.divide(-150d, 0d));
        } catch (Calculator.UnderflowException e) {
            System.out.println("3 - Divide Underflow!");
        }


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~AVERAGE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        try {
            System.out.println(calculator.average(Arrays.asList(1d,2d, null, 3d)));
        } catch (Calculator.NullParameterException e) {
            System.out.println("1 - NULL parameters found!");
        }

        try {
            System.out.println(calculator.average(Arrays.asList()));
        } catch (Calculator.NullParameterException e) {
            System.out.println("2 - NULL parameters found!");
        }

        try {
            System.out.println(calculator.average(Arrays.asList(1E308d, 1E308d, 1d, 2d, 1E308d)));
        } catch (Calculator.OverflowException e) {
            System.out.println("3 - Average Overflow!");
        }

        try {
            System.out.println(calculator.average(Arrays.asList(Double.NEGATIVE_INFINITY, 1d)));
        } catch (Calculator.UnderflowException e) {
            System.out.println("3 - Average Underflow!");
        }

        /**
         * Ex 3. Alegerea fireasca pentru exercitiul anterior este reprezentata de
         *       exceptiile CHECKED. Utilizatorul ar trebui sa fie instiintat ca a
         *       introdus un set de date invalid, dar programul nu ar trebui sa se
         *       opreasca in aceasta situatie. Optim ar fi sa se continue programul,
         *       iar utilizatorul sa poata sa introduca noi date si operatii.
         */
    }
}
