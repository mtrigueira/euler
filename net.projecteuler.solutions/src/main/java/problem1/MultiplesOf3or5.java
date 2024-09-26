package problem1;

public class MultiplesOf3or5 {
    static int sum(int i) {
        return new MultiplesOf3or5(i).sum;
    }

    private final int limit;
    private final int sum;

    private MultiplesOf3or5(int limit) {
        this.limit = limit;
        sum = calculateSum();
    }

    private int calculateSum() {
        int doubleCounts = sumOfMultiplesOf(15);

        return sumOfMultiplesOf(3) + sumOfMultiplesOf(5) - doubleCounts;
    }

    private int sumOfMultiplesOf(int n) {
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
