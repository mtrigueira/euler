package utils.roman;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static utils.roman.RomanDigitFrequency.MULTIPLE_ALLOWED;
import static utils.roman.RomanDigitFrequency.ONLY_ONCE;

class RomanDigit implements Comparable<RomanDigit> {
    static final Map<String, RomanDigit> digits = new HashMap<>();
    static final RomanDigit M = new RomanDigit("M", 1000);

    static {
        new RomanDigit("I", 1);
        new RomanDigit("IV", 4);
        new RomanDigit("V", 5, ONLY_ONCE);
        new RomanDigit("IX", 9);
        new RomanDigit("X", 10);
        new RomanDigit("XL", 40);
        new RomanDigit("L", 50, ONLY_ONCE);
        new RomanDigit("XC", 90);
        new RomanDigit("C", 100);
        new RomanDigit("CD", 400);
        new RomanDigit("D", 500, ONLY_ONCE);
        new RomanDigit("CM", 900);
    }

    private final String c;
    private final int i;
    private final RomanDigitFrequency romanDigitFrequency;

    public static RomanDigit romanDigit(String c) {
        return Optional.ofNullable(digits.get(c)).orElseThrow(() -> new NumberFormatException("Problem with digit: " + c));
    }

    public static RomanDigit getMaxFactor(int i) {
        return digits.values().stream().sorted()
                .takeWhile(d -> d.i <= i)
                .max(RomanDigit::compareTo)
                .orElse(M);
    }

    public int times(int x) throws NumberFormatException {
        if (x > 1 && ONLY_ONCE.equals(romanDigitFrequency))
            throw new NumberFormatException("Digit can only occur once: " + c);

        return i * x;
    }

    @Override
    public String toString() {
        return c;
    }

    @Override
    public int compareTo(RomanDigit other) {
        return Integer.compare(this.i, other.i);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RomanDigit that))
            return false;
        return i == that.i;
    }

    @Override
    public int hashCode() {
        return i;
    }

    private RomanDigit(String c, int i) {
        this(c, i, MULTIPLE_ALLOWED);
    }

    private RomanDigit(String c, int i, RomanDigitFrequency romanDigitFrequency) {
        this.c = c;
        this.i = i;
        this.romanDigitFrequency = romanDigitFrequency;
        digits.put(c, this);
    }
}
