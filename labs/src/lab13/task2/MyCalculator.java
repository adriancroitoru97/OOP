package lab13.task2;

import java.util.Collection;

public class MyCalculator implements  Calculator{
    @Override
    public Double add(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }

        double sum = nr1 + nr2;
        if (sum == Double.POSITIVE_INFINITY) {
            throw new OverflowException();
        }
        if (sum == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException();
        }

        return sum;
    }

    @Override
    public Double divide(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }

        double diff = nr1 / nr2;
        if (diff == Double.POSITIVE_INFINITY) {
            throw new OverflowException();
        }
        if (diff == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException();
        }

        return diff;
    }

    @Override
    public Double average(Collection<Double> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new NullParameterException();
        }

        double sum = 0;
        for (Double d : numbers) {
            sum = add(sum, d);
        }

        return divide(sum, (double) numbers.size());
    }
}
