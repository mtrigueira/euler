package utils.sequence.arithmetic;

public class A046641Fast {
    public static int a(int n) {
        int m = 1;

        while (A000041Fast.a(m,n) != 0)
            m++;

        return m;
    }

    private A046641Fast() {}
}
