package utils.prime;

public class CircularPrimeChecker {
    private CircularPrimeChecker() {
    }
    
    public static boolean isCircularPrime(long prime) {
        String digits = Long.toString(prime);
        int size = digits.length() - 1;

        for (int i = 0; i < size; i++) {
            digits = rotate(digits);
            if (!PrimeChecker.isPrime(Long.parseLong(digits)))
                return false;
        }

        return true;
    }

    private static String rotate(String digits) {
        return digits.substring(1) + digits.charAt(0);
    }
}
