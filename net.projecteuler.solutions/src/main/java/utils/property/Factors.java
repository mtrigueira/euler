package utils.property;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Set;

public class Factors {
    public static Set<Long> of(BigInteger n) {
        return of(n.longValueExact());
    }

    public static Set<Long> of(long n) {
        if (n < 1) return Collections.emptySet();

        Set<Long> s = ProperDivisors.of(n);
        s.add(n);

        return s;
    }

    public static boolean isFactor(BigInteger i, BigInteger candidate) {
        return i.mod(candidate).signum() == 0;
    }
}
