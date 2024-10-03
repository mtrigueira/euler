package utils;

import java.util.Collections;
import java.util.Set;

public class Factors {
    public static Set<Integer> of(int n) {
        if (n < 1) return Collections.emptySet();

        Set<Integer> s = ProperDivisors.of(n);
        s.add(n);

        return s;
    }
}
