package utils.property;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Set;

public class Factors {
    public static Set<BigInteger> of(long n) {
        return of(BigInteger.valueOf(n));
    }

    public static Set<BigInteger> of(BigInteger n) {
        if (n.signum() < 1) return Collections.emptySet();

        Set<BigInteger> s = ProperDivisors.of(n);
        s.add(n);

        return s;
    }

    public static boolean isFactor(BigInteger i, BigInteger candidate) {
        return i.mod(candidate).signum() == 0;
    }
}
