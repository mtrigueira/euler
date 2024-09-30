package utils;

public class Prime {
    private final long candidate;

    public static boolean isPrime(long candidate) {
        if(candidate<2) return false;

        return new Prime(candidate).isPrime();
    }

    private Prime(long candidate) {
        this.candidate = candidate;
    }

    private boolean isPrime() {
        for(long i=2;i<candidate;i++)
            if(isAFactor(i))
                return false;

        return true;
    }

    private boolean isAFactor(long factor) {
        return candidate % factor == 0;
    }
}
