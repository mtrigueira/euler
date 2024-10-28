package utils.sequence;

import org.junit.jupiter.api.Test;
import utils.prime.Prime;
import utils.sequence.arithmetic.IntegerSequence;
import utils.sequence.arithmetic.PrimeSequence;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequenceTest {
    @Test
    void intNextArray() {
        Sequence<?> sequence = new IntegerSequence();
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]",Arrays.toString(sequence.nextArray(10)));
    }

    @Test
    void primeNextArray() {
        Sequence<Prime> sequence = PrimeSequence.fromFirst();
        Prime[] primes = sequence.nextArray(10);
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]",Arrays.toString(primes));
    }

    @Test
    void primeNextArray0() {
        Sequence<Prime> sequence = PrimeSequence.fromFirst();
        Prime[] primes = sequence.nextArray(0);
        assertEquals("[]", Arrays.toString(primes));
    }

    @Test
    void primeNextArrayNoNext() {
        Sequence<String> sequence = new Sequence<>() {
            @Override
            public String next() {
                throw new NoSuchElementException();
            }

            @Override
            public boolean hasNext() {
                return false;
            }
        };
        String[] primes = sequence.nextArray(10);
        System.out.println(Arrays.toString(primes));
    }
}