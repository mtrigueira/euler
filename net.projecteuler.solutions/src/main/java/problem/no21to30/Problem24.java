package problem.no21to30;

import utils.Combiner;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem24 {
    public static final String DIGITS = "0123456789";

    public static void main(String[] args) {
        // https://projecteuler.net/problem=24
        System.out.println(permutation(1_000_000, DIGITS));
    }

    private int targetIndex;
    private int count = 0;
    private String found = "";

    private boolean findNTh(List<Integer> combination) {
        count++;
        if (count != targetIndex) return false;

        for (Integer integer : combination)
            found += integer;

        return true;
    }

    static String permutation(int i, String permutation) {
        Set<Integer> setOfIntegers = toSetOfIntegers(permutation);
        Combiner<Integer> combiner = Combiner.of(setOfIntegers);
        Problem24 lexicographicPermutations = new Problem24();
        lexicographicPermutations.targetIndex = i;

        combiner.combine(lexicographicPermutations::findNTh);

        return lexicographicPermutations.found;
    }

    private static Set<Integer> toSetOfIntegers(String permutation) {
        return permutation.chars().map(a -> a - '0').collect(TreeSet::new, Set::add, Set::addAll);
    }
}
