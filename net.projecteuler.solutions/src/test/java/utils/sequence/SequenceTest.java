package utils.sequence;

import org.junit.jupiter.api.Test;
import utils.prime.Prime;
import utils.sequence.arithmetic.IntegerSequence;
import utils.sequence.arithmetic.PrimeSequence;

import java.util.Arrays;

class SequenceTest {
    @Test
    void intNextArray() {
        Sequence<?> sequence = new IntegerSequence();
        System.out.println(Arrays.toString(sequence.nextArray(10)));
    }

    @Test
    void primeNextArray() {
        Sequence<Prime> sequence = PrimeSequence.fromFirst();
        Prime[] primes = sequence.nextArray(10);
        System.out.println(Arrays.toString(primes));
    }

    @Test
    void primeNextArray0() {
        Sequence<Prime> sequence = PrimeSequence.fromFirst();
        Prime[] primes = sequence.nextArray(0);
        System.out.println(Arrays.toString(primes));
    }
}