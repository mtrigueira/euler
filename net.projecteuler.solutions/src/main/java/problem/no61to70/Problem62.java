package problem.no61to70;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static problem.Solution.problem;

public class Problem62 {
     private Problem62() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=62
        problem("Cubic Permutations",
        () -> lowestValueWithCubicPermutations(5));
    }

    static BigInteger lowestValueWithCubicPermutations(int targetNumberOfPermutations) {
        if (targetNumberOfPermutations < 1)
            throw new IllegalArgumentException("Target number of permutations must be greater than 0");
        if (targetNumberOfPermutations == 1)
            return BigInteger.ZERO;

        HashMap<String, List<BigInteger>> map = new HashMap<>();
        for (int i = 0; ; i++) {
            BigInteger c = cube(i);
            String sameForPermutations = sortedDigits(c);

            if (map.containsKey(sameForPermutations)) {
                List<BigInteger> permutations = map.get(sameForPermutations);
                permutations.add(c);
                if(permutations.size() == targetNumberOfPermutations)
                    return permutations.get(0);

            } else {
                map.put(sameForPermutations, new ArrayList<>(List.of(c)));
            }
        }
    }

    private static String sortedDigits(BigInteger c) {
        return c.toString().chars().sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static BigInteger cube(int i) {
        return BigInteger.valueOf(i).pow(3);
    }
}
