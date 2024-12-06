package utils;

public class Pandigital {
    private static final String[] DIGITS = "123456789".split("");

    public static boolean isPandigital(long i) {
        if (lengthOfDigits(i) != 9) return false;
        String s = String.valueOf(i);

        for (String c : DIGITS)
            if (!s.contains(c)) return false;

        return true;
    }

    private static long lengthOfDigits(long i) {
        return (long) Math.log10(i) + 1;
    }

    private Pandigital() {
    }
}
