package problem;

import utils.sequence.arithmetic.A011900;
import utils.sequence.arithmetic.A046090;

import static problem.Solution.problem;

public class Problem100 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=100
        problem("Arranged probability", Problem100::solution);
    }

    private static long solution() {
        A011900 blueDisksInBox = new A011900();
        A046090 disksInBox = new A046090();
        long blue, disks;

        for (blue = 3, disks = 15; disks < 1_000_000_000_000L; ) {
            blue = blueDisksInBox.next();
            disks = disksInBox.next();
        }

        return blue;
    }

    private Problem100() {}
}
