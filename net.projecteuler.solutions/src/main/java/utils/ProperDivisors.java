package utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ProperDivisors {
    private final int n;
    private ProperDivisors(int n) {
            this.n = n;
        }

    public static Set<Integer> of(int i) {
        return new ProperDivisors(i).of();
    }

    public Set<Integer> of() {
        if (n < 1) return Collections.emptySet();
        Set<Integer> s = new HashSet<>();
        s.add(1);
        if (n == 1) return s;

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (isFactor(i)) {
                s.add(i);
                s.add(n / i);
            }

        return s;
    }

    private boolean isFactor(int i) {
        return n % i == 0;
    }
}
