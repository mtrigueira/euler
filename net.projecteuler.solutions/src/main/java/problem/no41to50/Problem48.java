package problem.no41to50;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem48 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=48
        problem("Self powers");
        solution(last10digits());
    }

    private static String last10digits() {
        String s = sumOfSelfPowers()
                .toString();
        
        return s.substring(s.length()-10);
    }

    private static BigInteger sumOfSelfPowers() {
        return IntStream.rangeClosed(1, 1000)
                .mapToObj(i -> BigInteger.valueOf(i).pow(i))
                .reduce(ZERO, BigInteger::add);
    }
}
