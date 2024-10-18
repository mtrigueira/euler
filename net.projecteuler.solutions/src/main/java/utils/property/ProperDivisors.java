package utils.property;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

public class ProperDivisors {
    private final BigInteger n;
    private ProperDivisors(BigInteger n) {
            this.n = n;
        }

    public static Set<BigInteger> of(BigInteger i) {
        return new ProperDivisors(i).of();
    }

    public static Set<BigInteger> of(long n) {
        return of(BigInteger.valueOf(n));
    }

    public Set<BigInteger> of() {
        if (n.signum() < 1) return Collections.emptySet();
        Set<BigInteger> s = new HashSet<>();
        if (ONE.equals(n)) return s;
        s.add(ONE);

        for (BigInteger i = TWO; lessThanOrEqual(i,n.sqrt()); i = i.add(ONE))
            if (isFactor(i)) {
                s.add(i);
                s.add(n.divide(i));
            }

        return s;
    }

    private boolean isFactor(BigInteger i) {
        return n.mod(i).signum() == 0;
    }
}
