package utils.prime;

import java.math.BigInteger;

public class CircularPrimeChecker {
    private CircularPrimeChecker() {
    }
    
    public static boolean isCircularPrime(Prime prime) {
        String digits = prime.toString();
        int size = digits.length() - 1;

        for (int i = 0; i < size; i++) {
            digits = rotate(digits);
            if (!PrimeChecker.isPrime(new BigInteger(digits)))
                return false;
        }

        return true;
    }

    private static String rotate(String digits) {
        return digits.substring(1) + digits.charAt(0);
    }
}
