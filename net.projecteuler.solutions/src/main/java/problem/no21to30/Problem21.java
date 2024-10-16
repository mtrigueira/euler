package problem.no21to30;

import utils.Amicable;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem21 {
    public static final int LIMIT = 10000;

    public static void main(String[] args) {
        // https://projecteuler.net/problem=21
        problem("Amicable numbers");
        solution(below(LIMIT));
    }

    static int below(int limit) {
        return new Amicable(limit - 1).sum();
    }
}
