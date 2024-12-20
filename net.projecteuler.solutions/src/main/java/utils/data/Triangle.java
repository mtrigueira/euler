package utils.data;

public class Triangle {
    private final short[][] triangle;

    public static Triangle of(String triangle) {
        return new Triangle(GridNumber.toShortGrid(triangle.lines()));
    }

    private static void calculateMaximumSumForRowUsingRowBelow(int row, short[][] triangle) {
        for (int column = 0; column <= row; column++) {
            short max = highestValueFromTwoAdjacentValuesOnRowBelow(row, column, triangle);
            if ((int) triangle[row][column] + max > Short.MAX_VALUE)
                throw new ArithmeticException("Overflow");
            triangle[row][column] += max;
        }
    }

    private static short highestValueFromTwoAdjacentValuesOnRowBelow(int row, int column, short[][] triangle) {
        short a = triangle[row + 1][column];
        short b = triangle[row + 1][column + 1];
        return a > b ? a : b;
    }

    public int maxPathSum() {
        short[][] accumulator = new short[triangle.length][triangle[0].length];
        System.arraycopy(triangle, 0, accumulator, 0, triangle.length);

        for (int row = accumulator.length - 2; row >= 0; row--)
            calculateMaximumSumForRowUsingRowBelow(row, accumulator);

        return accumulator[0][0];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                s.append(triangle[i][j]).append(" ");
            }
            s = new StringBuilder(s.toString().stripTrailing() + "\n");
        }
        s = new StringBuilder(s.toString().stripTrailing());
        return s.toString();
    }

    private Triangle(short[][] triangle) {
        this.triangle = triangle;
    }
}
