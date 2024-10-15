package problem.no41to50;

import java.math.BigInteger;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem48 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=48
        problem("Self powers");
        solution(last10digits());
    }

    private static String last10digits() {
        BigInteger sum = BigInteger.ZERO;
        BigInteger limit = BigInteger.valueOf(1000);

        for (BigInteger i = BigInteger.ONE; i.compareTo(limit) <= 0; i = i.add(BigInteger.ONE))
            sum = sum.add(i.pow(i.intValue()));

        String s = sum.toString();
        return s.substring(s.length()-10);
    }
}
