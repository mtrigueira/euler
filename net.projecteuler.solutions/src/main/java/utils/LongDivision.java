package utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class LongDivision {
    private final BigInteger denominator;
    private final List<BigPair> digits = new ArrayList<>();
    private BigInteger numerator;
    private int recurringCycle = -1;

    public LongDivision(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static LongDivision of(long numerator, long denominator) {
        return new LongDivision(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    long nextDigit() {
        BigInteger times = numerator.divide(denominator);
        numerator = numerator.subtract(times.multiply(denominator)).multiply(TEN);
        BigPair pair = BigPair.of(numerator, times);
        if (digits.contains(pair)) {
            recurringCycle = digits.indexOf(pair);
        } else {
            digits.add(pair);
        }
        return times.longValueExact();
    }

    boolean isRecurringCycle() {
        return recurringCycle != -1;
    }

    boolean isTerminated() {
        return numerator.equals(ZERO);
    }

    public int startOfRecurringCycle() {
        return recurringCycle;
    }

    record BigPair(BigInteger a, BigInteger b) {
        public static BigPair of(BigInteger a, BigInteger b) {
            return new BigPair(a, b);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof BigPair other) {
                return a.equals(other.a) && b.equals(other.b);
            }
            return false;
        }
    }
}
