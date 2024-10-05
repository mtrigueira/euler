package problem.no1to10.problem9;

class Triplet {
    public static Triplet of(int a, int b, int c) {
        return new Triplet(a, b, c);
    }

    private final int a, b, c;

    private Triplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    final int sum() {
        return a + b + c;
    }

    final int product() {
        return a * b * c;
    }
}
