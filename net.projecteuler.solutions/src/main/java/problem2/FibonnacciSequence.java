package problem2;

public class FibonnacciSequence {
    private int previous = 0;
    private int current = 1;
    public int next() {
        int temp = current;
        current = previous + current;
        previous = temp;
        return current;
    }

    public static void main(String[] args) {
        FibonnacciSequence fib = new FibonnacciSequence();
        int i = fib.next();
        System.out.print(i);
        fib.next();

        while (i <= 4000000) {
            System.out.print(", "+i);
            i = fib.next();
        }
    }
}
