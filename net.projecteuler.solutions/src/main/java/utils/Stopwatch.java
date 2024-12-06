package utils;

public class Stopwatch {
    private final long start = System.currentTimeMillis();

    public static Stopwatch start() {
        return new Stopwatch();
    }

    public void println() {
        System.out.println("Time taken: " + elapsed() + " ms");
    }

    public long elapsed() {
        return System.currentTimeMillis() - start;
    }
}
