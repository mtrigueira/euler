package utils.property;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class ProperDivisors {
    private final BigInteger n;

    private ProperDivisors(BigInteger n) {
        this.n = n;
    }

    public static Set<BigInteger> of(BigInteger i) {
        return new ProperDivisors(i).of();
    }

    public static Set<Long> of(long n) {
        if (n < 1) return Collections.emptySet();
        Set<Long> s = new HashSet<>();
        if (n == 1) return s;
        s.add(1L);

        long sqrt = (long)Math.sqrt(n);
        for (long i = 2; i <=sqrt; i++)
            if (Factors.isFactor(n,i)) {
                s.add(i);
                s.add(n / i);
            }

        return s;
    }

    public Set<BigInteger> of() {
        if (n.signum() < 1) return Collections.emptySet();
        Set<BigInteger> s = new HashSet<>();
        if (ONE.equals(n)) return s;
        s.add(ONE);


        BigInteger sqrt = n.sqrt().add(ONE);
        for (BigInteger i = TWO; sqrt.compareTo(i) > 0; i = i.add(ONE))
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
