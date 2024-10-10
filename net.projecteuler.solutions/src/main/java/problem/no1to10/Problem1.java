package problem.no1to10;

import utils.NaturalNumber;

public class Problem1 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=1
        System.out.println(naturalNumberSumOfMultiplesOf3or5(1000));
    }

    static int naturalNumberSumOfMultiplesOf3or5(int i) {
        var n = NaturalNumber.of(i);
        int doubleCounts = n.sumOfMultiplesOf(15);

        return n.sumOfMultiplesOf(3)
                + n.sumOfMultiplesOf(5)
                - doubleCounts;
    }
}

