package utils.sequence.arithmetic;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static utils.property.Evenness.isEven;

public class CollatzSequence extends ArithmeticSequence<BigInteger> {
    public static CollatzSequence of(long i) {
        return new CollatzSequence(BigInteger.valueOf(i));
    }

    private static final BigInteger THREE = BigInteger.valueOf(3);
    private BigInteger n;
    private static final Map<BigInteger,Integer> cache = new HashMap<>();

    private CollatzSequence(BigInteger start) {
        n = start;
    }

    @Override
    public BigInteger next() {
        BigInteger old = n;

        if (isEven(n))
            n = n.divide(TWO);
        else
            n = n.multiply(THREE).add(ONE);

        return old;
    }

    public int count() {
        BigInteger old = n;
        int count = 0;
        while (n.compareTo(ONE) > 0) {
            if(cache.containsKey(n)) {
                count += cache.get(n);
                break;
            }
            count++;
            next();
        }
        cache.put(old, count);
        return count;
    }
}
