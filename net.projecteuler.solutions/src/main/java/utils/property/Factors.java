package utils.property;

import java.util.Collections;
import java.util.Set;

public class Factors {
    public static Set<Long> of(long n) {
        if (n < 1) return Collections.emptySet();

        Set<Long> s = ProperDivisors.of(n);
        s.add(n);

        return s;
    }
}
