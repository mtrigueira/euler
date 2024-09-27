package problem3;

import java.util.OptionalLong;

public class LargestPrimeFactor {
    static OptionalLong of(long n) {
        if(n<2) return OptionalLong.empty();
        return OptionalLong.of(new LargestPrimeFactor(n).calculate());
    }

    private long largest;
    private long n;
    private long maxFactor;
    /* maxFactor
    PROOF BY CONTRADICTION
    For any prime number n.
    Given two factors a and b, with both greater than sqrt(n)
    Therefore a*b must be greater than sqrt(n)*sqrt(n) which is n
    But if a*b > n then a and b cannot both be factors of n
    So there can be at most one factor = sqrt(n)
     */

    public LargestPrimeFactor(long n) {
        this.n = n;
        maxFactor = sqrtWithDecimalTruncation(n);
    }

    private long sqrtWithDecimalTruncation(long n) {
        return (long)Math.sqrt(n);
    }

    private long calculate() {
        largest = 0;

        removeFactor(2);
        removeOddFactors();

        return largest;
    }

    private void removeOddFactors() {
        long candidate = 3;
        while (n > 1 && candidate<=maxFactor) {
            removeFactor(candidate);
            candidate += 2;
        }
        if(n!=1) largest = n;
    }

     private void removeFactor(long factor) {
        while (isAFactor(factor))
            removeFactorOnce(factor);
    }

    private boolean isAFactor(long candidate) {
        return n % candidate == 0;
    }

    private void removeFactorOnce(long factor) {
        n /= factor;
        largest = factor;
        maxFactor = sqrtWithDecimalTruncation(n);
    }

    public static void main(String[] args) {
        System.out.println(of(600851475143L));
    }
}
