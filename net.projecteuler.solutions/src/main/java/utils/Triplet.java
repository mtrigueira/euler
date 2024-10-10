package utils;

public class Triplet {
    public static Triplet of(int a, int b, int c) {
        return new Triplet(a, b, c);
    }

    private final int a, b, c;

    private Triplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public final int sum() {
        return a + b + c;
    }

    public final int product() {
        return a * b * c;
    }

    @Override
    public String toString() {
        return "{" + a + ", " + b + ", " + c + '}';
    }
}
