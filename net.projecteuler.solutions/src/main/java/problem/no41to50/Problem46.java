package problem.no41to50;

import utils.prime.Prime;
import utils.sequence.arithmetic.CompositeSequence;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.Optional;

import static java.math.BigInteger.TWO;
import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem46 {
    public static void main(String[] args) {
        problem("Goldbach's other conjecture");
        solution(goldbachsOtherConjecture().map(BigInteger::toString).orElse("Not found"));
    }

    private static Optional<BigInteger> goldbachsOtherConjecture() {
        return new CompositeSequence().stream()
                .filter(x -> x.testBit(0))
                .filter(x -> !canBeWrittenAsSumOfPrimesAnd2TimesSquare(x))
                .limit(1)
                .findAny();
    }

    private static boolean canBeWrittenAsSumOfPrimesAnd2TimesSquare(BigInteger x) {
        return PrimeSequence.fromFirst().stream()
                .takeWhile(p -> x.compareTo(p) > 0)
                .anyMatch(p ->
                        goldbachOtherConjecture(x, p)
                                .equals(x));
    }

    private static BigInteger goldbachOtherConjecture(BigInteger x, Prime p) {
        return caculateNumberToBeSquared(x, p)
                .pow(2)
                .multiply(TWO)
                .add(p);
    }

    private static BigInteger caculateNumberToBeSquared(BigInteger x, Prime p) {
        return x.subtract(p)
                .divide(TWO)
                .sqrt();
    }
}
