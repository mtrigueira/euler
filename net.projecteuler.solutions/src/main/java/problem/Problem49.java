package problem;

import utils.prime.Prime;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static problem.Solution.problem;

public class Problem49 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=49
        problem("Prime permutations",
                () -> primePermutations(EXCLUDE));
    }

    public static final List<Integer> EXCLUDE = List.of(1487);

    static String primePermutations(List<Integer> exclude) {
        List<Integer> primes = Prime.eratosthenesSieve(9999).stream().dropWhile(a1 -> a1 < 1000).filter(a -> !exclude.contains(a)).toList();
        List<String> sortedStrings = primes.stream().map(Problem49::sortDigits).toList();
        Map<String, Set<Integer>> permutations = new HashMap<>();

        for (int i = 0; i < primes.size() - 2; i++) {
            String sortedA = sortedStrings.get(i);
            for (int j = i + 1; j < primes.size(); j++) {
                String sortedB = sortedStrings.get(j);
                if (sortedA.equals(sortedB)) {
                    int a = primes.get(i);
                    int b = primes.get(j);
                    Set<Integer> set = permutations.getOrDefault(sortedA, new HashSet<>());
                    set.add(a);
                    set.add(b);
                    permutations.put(sortedA, set);
                }
            }
        }

        return permutations.values().stream().filter(combos -> combos.size() >= 3)
                .flatMap(Problem49::triplets)
                .collect(Collectors.joining(","));
    }

    private static Stream<String> triplets(Set<Integer> combos) {
        return combos.stream().flatMap(a ->
                combos.stream().filter(b -> a < b).flatMap(b ->
                        combos.stream()
                                .filter(c -> b < c)
                                .filter(c ->
                                        areEquidistant(a, b, c))
                                .map(c -> "" + a + b + c)
                )
        );
    }

    private static boolean areEquidistant(int a, int b, int c) {
        return delta(b, a) == delta(c, b);
    }

    private static int delta(int b, int a) {
        return b - a;
    }

    private static String sortDigits(int a) {
        byte[] sorted = Integer.toString(a).getBytes();
        Arrays.sort(sorted);
        return new String(sorted);
    }

    private Problem49() {}
}
