package utils;

import java.util.*;
import java.util.function.Consumer;

public class Combiner<T> {
    private final List<T> prefix;
    private final Set<T> set;
    private Consumer<List<T>> processCombination;

    private Combiner(Set<T> set) {
        TreeSet<T> determanisticSet = new TreeSet<>(set);
        this.set = determanisticSet;
        this.prefix = new ArrayList<>(set.size());
        processCombination = Combiner::doNothing;
    }

    private static <T> void doNothing(List<T> combination) {
    }

    public static <T> Combiner<T> of(Set<T> digits) {
        return new Combiner<>(digits);
    }

    public void combine(Consumer<List<T>> processCombination) {
        this.processCombination = processCombination;
        combine(set);
    }

    private void combine(Set<T> set) {
        if (set.isEmpty()) {
            processCombination.accept(prefix);
            return;
        }
        Set<T> remainder = new HashSet<>(set);
        for (T element : set) {
            remainder.remove(element);
            prefix.add(element);
            combine(remainder);
            prefix.remove(element);
            remainder.add(element);
        }
    }
}