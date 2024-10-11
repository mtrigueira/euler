package problem.no31to40;

import utils.sequence.arithmetic.ChampernowneSequence;

public class Problem40 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=40
        System.out.println(productOfChampernownesConstant());
    }

    private static long productOfChampernownesConstant() {
        ChampernowneSequence champernowneSequence = new ChampernowneSequence();
        long product = 1;

        long nextNth = 1;
        for(int i = 1; i <= 1_000_000; i++) {
            Byte b = champernowneSequence.next();
            if (i % nextNth == 0) {
                nextNth *= 10;
                product *= b;
            }
        }

        return product;
    }
}
