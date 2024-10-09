package utils.sequence.arithmetic;

import utils.prime.Prime;
import utils.prime.PrimeChecker;
import utils.sequence.Sequence;

import java.math.BigInteger;

public class PrimeSequence extends Sequence<Prime> {
    private static final Prime TWO = Prime.of(BigInteger.TWO).orElseThrow();
    private static final Prime THREE = Prime.of(BigInteger.valueOf(3)).orElseThrow();
    private static final Prime FIRST_PRIME = TWO;
    private Prime current;

    private PrimeSequence(Prime start) {
        this.current = start;
    }

    private PrimeSequence() {
        this(FIRST_PRIME);
    }

    public static PrimeSequence from(int i) {
        return new PrimeSequence(Prime.of(BigInteger.valueOf(i)).orElseThrow());
    }

    public static PrimeSequence fromFirst() {
        return new PrimeSequence();
    }

    @Override
    public Prime next() {
        Prime last = current;
        if (TWO.equals(current)) {
            current = THREE;
            return last;
        }

        BigInteger currentValue = current.toBigInteger();
        do
            currentValue = BigInteger.TWO.add(currentValue);
        while (!PrimeChecker.isPrime(currentValue));
        current = Prime.of(currentValue).orElseThrow();

        return last;
    }
}
