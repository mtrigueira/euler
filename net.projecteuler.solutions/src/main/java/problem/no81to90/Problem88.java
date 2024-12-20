package problem.no81to90;

import java.util.HashSet;
import java.util.Set;

import static problem.Solution.problem;

public class Problem88 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=88
        problem("Product-sum numbers", Problem88::solution);
    }

    public static final int LIMIT = 12;

    private final int k;
    private final int[] sums;
    private final int[] products;
    private final int[] froms;
    private final int[] remainders;
    private int minProdSum;

    static long solution() {
        Set<Integer> uniqueProductSums = new HashSet<>();

        for (int k = 2; k <= LIMIT; k++) {
            int minimalProductSum = minimalProductSum(k);
            uniqueProductSums.add(minimalProductSum);
//            System.out.println(k + "," + minimalProductSum);
        }

        return uniqueProductSums.stream().mapToInt(Integer::intValue).sum();
    }

    public static int minimalProductSum(int k) {

        Problem88 problem88 = new Problem88(k);
        problem88.minimalProductSumR(0);
        return problem88.minProdSum;
    }

    private void minimalProductSumR(int i) {
        for (; froms[i + 1] <= remainders[i]; froms[i + 1]++) {
            if (k != i + 1) {
                sums[i + 1] = sums[i] + froms[i + 1];
                products[i + 1] = products[i] * froms[i + 1];
                prepare(i + 1);
                minimalProductSumR(i + 1);
            } else {
                if (sums[i] % froms[i + 1] == 0)
                    if (sums[i] == (products[i] - 1) * froms[i + 1]) {
                        minProdSum = sums[i] + froms[i + 1];
                        break;
                    }
            }
        }
    }

    private void prepare(int i) {
        remainders[i] = minProdSum - sums[i] - k + i;

        if (remainders[i] * (products[i] - 1) > sums[i])
            remainders[i] = sums[i] / (products[i] - 1);

        froms[i + 1] = froms[i];
    }

    private Problem88(int k) {
        this.k = k;
        this.minProdSum = k * 2; // Étienne Dupuis, Dec 07 2021
        this.sums = new int[k + 1];
        this.products = new int[k + 1];
        this.products[0] = 1;
        this.froms = new int[k + 1];
        this.froms[0] = 1;
        this.froms[1] = 1;
        this.remainders = new int[k + 1];
        this.remainders[0] = this.minProdSum;
    }
}
