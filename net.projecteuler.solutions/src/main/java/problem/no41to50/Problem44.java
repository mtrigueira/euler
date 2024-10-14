package problem.no41to50;

import utils.sequence.arithmetic.PentagonalSequence;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem44 {

    public static void main(String[] args) {
        // https://projecteuler.net/problem=44
        problem("Pentagonal numbers");
        solution(minimumDifferenceforPentagonalPairs());
    }

    private static BigInteger minimumDifferenceforPentagonalPairs() {
        PentagonalSequence seq = new PentagonalSequence();
        Deque<BigInteger> pentagonals = new ArrayDeque<>();

        pentagonals.add(seq.next());
        pentagonals.add(seq.next());

        while (true) {
            BigInteger sum = seq.next();

            for (Iterator<BigInteger> kIt = pentagonals.descendingIterator(); kIt.hasNext(); ) {
                BigInteger k = kIt.next();
                BigInteger j = sum.subtract(k);

                if (PentagonalSequence.isPentagonal(j)) {
                    BigInteger D = k.subtract(j).abs();
                    if (PentagonalSequence.isPentagonal(D))
                        return D;
                }
            }

            pentagonals.add(sum);
        }
    }
}
