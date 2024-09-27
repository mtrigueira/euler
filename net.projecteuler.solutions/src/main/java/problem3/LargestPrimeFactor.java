package problem3;

public class LargestPrimeFactor {
    public static long largestPrimeFactor(long i) {
        long prime = 2;
        long largest = 0;

        while (i > 1)
            if (i % prime == 0) {
                i /= prime;
                largest = prime;
            } else
                prime++;

        return largest;
    }

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(600851475143L));
    }
}
