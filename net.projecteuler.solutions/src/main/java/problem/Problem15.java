package problem;

import utils.data.Lattice;

import static problem.Solution.problem;

public class Problem15 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=15
        problem("Lattice paths",
                () ->
                        numberOfRoutesThroughALatticeOfSize(20));
    }

    static long numberOfRoutesThroughALatticeOfSize(int n) {
        return new Lattice(n).countRoutes();
    }

    private Problem15() {}
}
