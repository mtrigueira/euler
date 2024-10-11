package problem.no21to30;

import utils.sequence.given.CombinationSequence;

import java.util.List;

public class Problem24 {
    public static final String DIGITS = "0123456789";

    public static void main(String[] args) {
        // https://projecteuler.net/problem=24
        System.out.println(permutation(1_000_000, DIGITS));
    }

    static String permutation(int n, String s) {
        List<String> permutation =  List.of(s.split(""));
        CombinationSequence<String> combiner = new CombinationSequence<>(permutation, (a, b) -> a + b);

        for(int i = 1; i < n; i++)
            combiner.next();

        return combiner.next();
    }
}
