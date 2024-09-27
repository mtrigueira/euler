package problem1;

public class MultiplesOf3or5 {
    static int sum(int limit) {
        int doubleCounts = sumOfMultiplesOf(15, limit);

        return sumOfMultiplesOf(3, limit)
                + sumOfMultiplesOf(5, limit)
                - doubleCounts;
    }

    private static int sumOfMultiplesOf(int n, int limit) {
        int numberOfMultiples = (limit - 1) / n;

        return sumOfNaturalNumbersTo(numberOfMultiples) * n;
    }

    static int sumOfNaturalNumbersTo(int n) {
        // Gauss sum of pairs trick
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(sum(1000));
    }
}
