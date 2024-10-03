package utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ProperDivisors {
    private final long n;
    private ProperDivisors(long n) {
            this.n = n;
        }

    public static Set<Long> of(long i) {
        return new ProperDivisors(i).of();
    }

    public Set<Long> of() {
        if (n < 1) return Collections.emptySet();
        Set<Long> s = new HashSet<>();
        if (n == 1) return s;
        s.add(1L);

        for (long i = 2; i <= Math.sqrt(n); i++)
            if (isFactor(i)) {
                s.add(i);
                s.add(n / i);
            }

        return s;
    }

    private boolean isFactor(long i) {
        return n % i == 0;
    }
}
