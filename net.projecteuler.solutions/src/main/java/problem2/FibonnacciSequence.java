package problem2;

import utils.Sequence;

import static problem2.Evenness.isEven;

public class FibonnacciSequence extends Sequence {
    private int previous = 0;
    private int current = 1;
    @Override
    public long next() {
        int temp = current;
        current = previous + current;
        previous = temp;
        return current;
    }

    public static void main(String[] args) {
        FibonnacciSequence fib = new FibonnacciSequence();
        fib.next();
        long i = fib.next();
        System.out.print(i);

        while (i <= 4000000) {
            if(isEven(i))
                System.out.print(", "+i);
            i = fib.next();
        }
    }
}
