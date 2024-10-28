package problem.no21to30;

import java.util.stream.IntStream;

import static problem.Solution.problem;

public class Problem29 {
     private Problem29() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=29
        problem("Distinct powers",
        () -> numberOfDistinctTerms(100, 100));
    }

    static long numberOfDistinctTerms(int aLimit, int bLimit) {
        return IntStream.rangeClosed(2, aLimit).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(2, bLimit)
                                .mapToObj(b -> Math.pow(a, b))
                ).distinct()
                .count();
    }
}
