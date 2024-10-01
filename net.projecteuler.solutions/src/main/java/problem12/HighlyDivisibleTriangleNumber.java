package problem12;

public class HighlyDivisibleTriangleNumber {
    public static void main(String[] args) {
        int numberOfDivisors = 500;

        System.out.println(withOver(numberOfDivisors));
    }

    static long withOver(int numberOfDivisors) {
        if(numberOfDivisors<1) return 0;
        TriangleNumberSequence sequence = new TriangleNumberSequence();
        long candidate = 0;
        int count = 0;

        while (count < numberOfDivisors) {
            candidate = sequence.next();
            count = countFactors(candidate);
        }

        return candidate;
    }

    static int countFactors(long candidate) {
        if (candidate<1) return 0;
        if (candidate==1) return 1;
        int count=0;

        for(int i=1;i<=Math.sqrt(candidate);i++)
            if(candidate % i==0)
                count+=2;

        return count;
    }
}
