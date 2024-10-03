package utils;

public class Aliquot {
    public static boolean isAbundant(long i) {
        return sumOfDivisors(i) > i;
    }

    public static boolean isPerfect(long i) {
        return sumOfDivisors(i) == i;
    }

    public static boolean isDeficient(long i) {
        return sumOfDivisors(i) < i;
    }

    private static long sumOfDivisors(long i) {
        return ProperDivisors.of(i).stream().mapToLong(Long::longValue).sum();
    }
}
