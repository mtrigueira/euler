package problem.no61to70;

import utils.continuedFraction.ContinuedFraction;
import utils.SimpleFraction;

import static problem.Solution.problem;

public class Problem65 {
     private Problem65() {
     }
    public static void main(String[] args) {
        // https://projecteuler.net/problem=65
        problem("Convergents of e",
        () -> convergentsOfE(100));
    }

    static int convergentsOfE(int n) {
        ContinuedFraction e = ContinuedFraction.e();
        SimpleFraction f = SimpleFraction.of(0);

        for (int i = 0; i < n; i++)
            f = f.add(SimpleFraction.of(e.at(i))).reciprocal();

        return f.denominator().toString().chars().map(c -> c - '0').sum();
    }
}
