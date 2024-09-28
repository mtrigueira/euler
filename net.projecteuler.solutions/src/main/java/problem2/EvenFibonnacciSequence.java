package problem2;

import utils.Sequence;

public class EvenFibonnacciSequence extends Sequence {
    private int previous = 2;
    private int current = 0;
    @Override
    public long next() {
        int temp = current;
        current = previous + 4*current;
        previous = temp;
        return current;
    }

    public static void main(String[] args) {
        EvenFibonnacciSequence fib = new EvenFibonnacciSequence();
        long i = fib.next();

        while (i <= 4000000) {
            System.out.print(", "+i);
            i = fib.next();
        }
    }
}
