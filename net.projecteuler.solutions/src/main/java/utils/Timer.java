package utils;

public class Timer {
    public static Timer start() {
        return new Timer();
    }

    private final long start = System.currentTimeMillis();

    public void println() {
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + " ms");
    }
}
