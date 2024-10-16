package utils;

public record Triplet(int a, int b, int c) {
    public static Triplet of(int a, int b, int c) {
        return new Triplet(a, b, c);
    }

    public int sum() {
        return a + b + c;
    }

    public int product() {
        return a * b * c;
    }

    @Override
    public String toString() {
        return "{" + a + ", " + b + ", " + c + '}';
    }
}
