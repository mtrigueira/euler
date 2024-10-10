package problem.no31to40;

import utils.Combiner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem32 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=32
        Combiner<Integer> combiner = Combiner.of(DIGITS);
        combiner.combine(Problem32::accumulateWhereIdentityMatches);
        System.out.println(
                products.stream()
                .mapToInt(x->x)
                .sum()
        );
    }

    private static final Set<Integer> products = new HashSet<>();
    private static void accumulateWhereIdentityMatches(List<Integer> combination) {
        for(int i=0;i<combination.size()-3;i++)
            for(int j=i+1;j<combination.size()-2;j++)
                addIfIdentityMatches(combination, i, j);
    }

    private static void addIfIdentityMatches(List<Integer> combination, int i, int j) {
        int multiplicand = squish(combination,0, i);
        int multiplier = squish(combination, i +1, j);
        int product = squish(combination, j +1, combination.size()-1);

        if (multiplicand * multiplier == product)
            products.add(product);
    }

    static int squish(List<Integer> combination, int start, int end) {
        int value = 0;

        for(int i=start;i<=end;i++)
            value = value * 10 + combination.get(i);

        return value;
    }

    private static final Set<Integer> DIGITS = Set.of(1,2,3,4,5,6,7,8,9);
}
