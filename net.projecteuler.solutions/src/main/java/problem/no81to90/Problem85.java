package problem.no81to90;

import static problem.Solution.problem;

public class Problem85 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=85
        problem("Counting rectangles", Problem85::areadOfGridWithMaximumRectanglesInGridBelow2_000_000);
    }

    private static int areadOfGridWithMaximumRectanglesInGridBelow2_000_000() {
        int columns = 1;
        int rows = 1;
        int max = 0;
        int maxArea = 0;

        while (true) {
            int rectangles = countRectanglesInGrid(rows, columns);
            if (rectangles < 2_000_000) {
                if (rectangles > max) {
                    max = rectangles;
                    maxArea = rows * columns;
                }
                columns++;
            } else {
                if (columns > rows) {
                    rows++;
                    columns = maxArea / rows;
                } else
                    break;
            }
        }

        return maxArea;
    }

    static int countRectanglesInGrid(int rows, int columns) {
        int rectangles = 0;

        for (int j = 0; j < rows; j++)
            for (int i = 0; i < columns; i++)
                rectangles += (rows - j) * (columns - i);

        return rectangles;
    }
}
