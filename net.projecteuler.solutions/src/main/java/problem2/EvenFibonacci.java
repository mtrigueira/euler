package problem2;

import static problem2.Evenness.isEven;

public class EvenFibonacci {
    public static int sum(int limit) {
        FibonnacciSequence fib = new FibonnacciSequence();
        int sum = 0;

        for (int a = fib.next(); a <= limit; a = fib.next())
            if (isEven(a)) sum += a;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(4000000));
    }
}
