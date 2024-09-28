package problem2;

public class EvenFibonacciSum {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=2
        System.out.println(sum(4000000));
    }

    public static int sum(int limit) {
        Sequence fib = new EvenFibonnacciSequence();
        int sum = 0;

        for (int a = fib.next(); a <= limit; a = fib.next())
            sum += a;

        return sum;
    }
}
