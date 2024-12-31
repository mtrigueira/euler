package problem.no21to30;

import utils.Amicable;

import static problem.Solution.problem;

public class Problem21 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=21
        problem("Amicable numbers",
                () -> below(LIMIT));
    }

    public static final int LIMIT = 10000;

    static int below(int limit) {
        return new Amicable(limit - 1).sum();
    }

    private Problem21() {}
}
