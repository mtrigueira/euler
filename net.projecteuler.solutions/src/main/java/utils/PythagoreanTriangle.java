package utils;

public class PythagoreanTriangle {

    public static int calculateC(int a, int b, int perimiter) {
        return perimiter - a - b;
    }

    public static boolean isPythagoreanTriplet(int a, int b, int c) {
        return a * a + b * b == c * c;
    }

    public static int product(int a, int b, int c) {
        return a * b * c;
    }
}
