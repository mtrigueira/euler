package utils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Combiner<T> {
    private final List<T> prefix;
    private final Set<T> set;
    private Function<List<T>,Boolean> processCombination;

    private Combiner(Set<T> set) {
        TreeSet<T> determanisticSet = new TreeSet<>(set);
        this.set = determanisticSet;
        this.prefix = new ArrayList<>(set.size());
        processCombination = Combiner::doNothing;
    }

    private static <T> boolean doNothing(List<T> combination) {
        return true;
    }

    public static <T> Combiner<T> of(Set<T> digits) {
        return new Combiner<>(digits);
    }

    public void combine(Consumer<List<T>> processCombination) {
        this.processCombination = wrapProcessThatDoesntReturnEarlyExifFlag -> {
            processCombination.accept(wrapProcessThatDoesntReturnEarlyExifFlag);
            return false;
        };
        combine(set);
    }

    public void combine(Function<List<T>, Boolean> processCombination) {
        this.processCombination = processCombination;
        combine(set);
    }

    private boolean combine(Set<T> set) {
        if (set.isEmpty())
            return processCombination.apply(prefix);

        Set<T> remainder = new HashSet<>(set);
        for (T element : set) {
            remainder.remove(element);
            prefix.add(element);
            if(combine(remainder)) return true;
            prefix.remove(element);
            remainder.add(element);
        }
        return false;
    }
}