package utils.prime;

import java.math.BigInteger;
import java.util.Optional;

import static utils.data.DigitNumber.toByteArray;
import static utils.data.DigitNumber.toLong;

public class CircularPrimeChecker {
    public static boolean isCircularPrime(Prime prime) {
        long primeLong = prime.longValueExact();
        long digits = lengthOfDigits(primeLong);

        for (int i = 0; i < digits - 1; i++)
            if (rotate(primeLong).isEmpty())
                return false;

        return true;
    }

    private static long lengthOfDigits(long i) {
        return (long) Math.log10(i) + 1;
    }

    private static Optional<Prime> rotate(long prime) {
        return Prime.of(BigInteger.valueOf(rotate2(prime)));
    }

    private static int rotate2(long prime) {
        byte[] bytes = rotate(toByteArray(prime));
        return Math.toIntExact(toLong(bytes));
    }

    private static byte[] rotate(byte[] bytes) {
        byte first = bytes[0];
        System.arraycopy(bytes, 1, bytes, 0, bytes.length - 1);
        bytes[bytes.length - 1] = first;

        return bytes;
    }
}
