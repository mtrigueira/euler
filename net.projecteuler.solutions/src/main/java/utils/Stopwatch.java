package utils;

public class Stopwatch {
    public static Stopwatch start() {
        return new Stopwatch();
    }

    private final long start = System.currentTimeMillis();

    public void println() {
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + " ms");
    }
}
