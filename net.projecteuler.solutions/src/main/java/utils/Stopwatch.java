package utils;

public class Stopwatch {
    public static Stopwatch start() {
        return new Stopwatch();
    }

    private final long start = System.currentTimeMillis();

    public void println() {
        System.out.println("Time taken: " + elapsed() + " ms");
    }

    public long elapsed() {
        return System.currentTimeMillis() - start;
    }
}
