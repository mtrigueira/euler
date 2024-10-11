package utils.prime;

import java.math.BigInteger;
import java.util.Optional;

public class Prime extends BigInteger {
    private Prime(byte[] val) {
        super(val);
    }

    public static Optional<Prime> of(BigInteger i) {
        return PrimeChecker.isPrime(i)?Optional.of(new Prime(i.toByteArray())):Optional.empty();
    }

    public Prime max(Prime val) {
        return (Prime) super.max(val);
    }
}
