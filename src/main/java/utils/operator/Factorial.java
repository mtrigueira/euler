package utils.operator;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class Factorial {
    public static long of(int n) {
        return ofBig(n).longValueExact();
    }

    public static BigInteger ofBig(long n) {
        return ofBig(BigInteger.valueOf(n));
    }

    public static BigInteger ofBig(BigInteger n) {
        if (ZERO.equals(n))
            return BigInteger.ONE;
        if (n.signum() == -1)
            throw new IllegalArgumentException("Factorial is undefined for negative numbers");

        return factorial(n);
    }

    private static BigInteger factorial(BigInteger n) {
        return ONE.equals(n) ? ONE : n.multiply(factorial(n.subtract(ONE)));
    }

    private Factorial() {
    }

}
