package problem.no11to20;

import utils.data.Lattice;

import static problem.Solution.problem;
import static problem.Solution.solution;

public class Problem15 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=15
        problem("Lattice paths");
        solution(numberOfRoutesThroughALatticeOfSize(20));
    }

    static long numberOfRoutesThroughALatticeOfSize(int n) {
        return new Lattice(n).countRoutes();
    }
}
