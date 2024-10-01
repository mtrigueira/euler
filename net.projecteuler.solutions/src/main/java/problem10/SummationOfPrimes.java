package problem10;

import utils.PrimeSequence;

public class SummationOfPrimes {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=10
        long start=System.currentTimeMillis();
        System.out.println(below(2000000));
        System.out.println("Time taken: "+(System.currentTimeMillis()-start)+"ms");
    }

    static long below(int limit) {
        PrimeSequence seq = new PrimeSequence();
        long sum = 0;

        for (long prime = seq.next();prime<limit;prime = seq.next())
            sum += prime;

        return sum;
    }
}
