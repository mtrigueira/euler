package problem.no21to30;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.operator.BigComparisonOperator.lessThanOrEqual;

public class Problem29 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=29
        problem("Distinct powers");
        solution(numberOfDistinctTerms(100, 100));
    }

    static int numberOfDistinctTerms(int aLimit, int bLimit) {
        Set<BigInteger> terms = new HashSet<>();
        BigInteger aMax = BigInteger.valueOf(aLimit);

        for(BigInteger a = TWO; lessThanOrEqual(a, aMax); a = a.add(ONE))
            for(int b = 2; b <= bLimit; b++)
                terms.add(a.pow(b));

        return terms.size();
    }
}
