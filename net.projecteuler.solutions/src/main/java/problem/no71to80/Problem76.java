package problem.no71to80;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static problem.Solution.problem;

public class Problem76 {
    static Set<String> c = new HashSet<>();
    private static int target;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=76
        problem("", () ->
                solution(100));
    }

    static int solution(int i) {
        c.clear();
        target = i;
        combinations(List.of(),0, i);

        return c.size();
    }

    private static String ordered(String s) {
        return Stream.of(s.split(",")).mapToInt(Integer::parseInt).sorted().mapToObj(Integer::toString).collect(Collectors.joining(","));
    }

    static void combinations(List<Integer> prefix, int presum, int n) {
        if (presum + n == target && !prefix.isEmpty()) {
            String s = prefix.stream().map(Object::toString).reduce("" + n, (a, b) -> a + "," + b);
            s = ordered(s);
            c.add(s);
        }

        for (int i = n - 1; i >= 1; i--) {
            List<Integer> p2 = new ArrayList<>(prefix);
            p2.add(i);
            combinations(p2, presum+i,(n - i));
        }
    }
}
