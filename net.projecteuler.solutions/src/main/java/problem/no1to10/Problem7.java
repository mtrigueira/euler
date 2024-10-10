package problem.no1to10;

import utils.prime.Prime;
import utils.sequence.LimitedSequence;
import utils.sequence.arithmetic.PrimeSequence;

public class Problem7 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=7
        System.out.println(prime(10001));
    }

    public static Prime prime(int n) {
        LimitedSequence<Prime> seq = LimitedSequence.of(PrimeSequence.fromFirst(),n);

        return seq.last();
    }
}
