package problem.no41to50;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static java.math.BigInteger.ZERO;
import static problem.Solution.problem;

public class Problem48 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=48
        problem("Self powers",
                () -> lastDigits(10));
    }

    static String lastDigits(int i) {
        String s = sumOfSelfPowers()
                .toString();

        return s.substring(s.length() - i);
    }

    private static BigInteger sumOfSelfPowers() {
        return IntStream.rangeClosed(1, 1000)
                .mapToObj(i -> BigInteger.valueOf(i).pow(i))
                .reduce(ZERO, BigInteger::add);
    }

    private Problem48() {
    }
}
