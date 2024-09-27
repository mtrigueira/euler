package problem2;

public class EvenFibonacciSum {
    public static int sum(int limit) {
        Sequence fib = new EvenFibonnacciSequence();
        int sum = 0;

        for (int a = fib.next(); a <= limit; a = fib.next())
            sum += a;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(4000000));
    }
}
