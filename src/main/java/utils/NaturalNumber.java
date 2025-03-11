package utils;

public class NaturalNumber {
    private final int value;

    public static NaturalNumber of(int value) {
        if (value <= 0)
            throw new IllegalArgumentException("Natural number must be positive");

        return new NaturalNumber(value);
    }

    static int sumTo(int n) {
        // Gauss sum of pairs trick
        return n * (n + 1) / 2;
    }

    public int sumOfMultiplesOf(int n) {
        int numberOfMultiples = (value - 1) / n;

        return sumTo(numberOfMultiples) * n;
    }

    private NaturalNumber(int value) {
        this.value = value;
    }
}
