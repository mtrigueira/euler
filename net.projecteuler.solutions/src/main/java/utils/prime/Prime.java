package utils.prime;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public class Prime {
    private final BigInteger value;
    private final long longValue;

    public Prime(BigInteger value) {
        this.value = value;
        longValue = value.longValue();
    }

    public static Optional<Prime> of(BigInteger i) {
        return PrimeChecker.isPrime(i)?Optional.of(new Prime(i)):Optional.empty();
    }

    public BigInteger toBigInteger() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prime prime = (Prime) o;
        if (((Prime) o).longValue != longValue) return false;
        return Objects.equals(value, prime.value);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(longValue);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
