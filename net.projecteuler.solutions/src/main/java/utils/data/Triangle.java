package utils.data;

public class Triangle {
    private final short[][] triangle;

    private Triangle(short[][] triangle) {
        this.triangle = triangle;
    }

    public static Triangle of(String triangle) {
        return new Triangle(GridNumber.toShortGrid(triangle));
    }

    public int maxPathSum() {
        for (int row = triangle.length - 2; row >= 0; row--)
            calculateMaximumSumForRowUsingRowBelow(row);

        return triangle[0][0];
    }

    private void calculateMaximumSumForRowUsingRowBelow(int row) {
        for (int column = 0; column <= row; column++) {
            short max = highestValueFromTwoAdjacentValuesOnRowBelow(row, column);
            if ((int)triangle[row][column] + max > Short.MAX_VALUE) throw new ArithmeticException("Overflow");
            triangle[row][column] += max;
        }
    }

    private short highestValueFromTwoAdjacentValuesOnRowBelow(int row, int column) {
        short a = triangle[row + 1][column];
        short b = triangle[row + 1][column + 1];
        return a > b ? a : b;
    }
}
