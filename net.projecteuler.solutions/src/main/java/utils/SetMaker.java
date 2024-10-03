package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMaker {
    static Set<Long> set(int... values) {
        return Arrays.stream(values).asLongStream().collect(HashSet::new, HashSet::add, HashSet::addAll);
    }
}
