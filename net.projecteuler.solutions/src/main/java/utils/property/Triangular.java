package utils.property;

public class Triangular {
    static long atPosition(long i) {
        return i*(i+1)/2;
    }

    public static boolean isTriangular(long x) {
        long position = (long) ((-1 + Math.sqrt(1 + 8*x)) / 2);
        return x == atPosition(position);
    }
}
