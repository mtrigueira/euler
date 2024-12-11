package utils.data;

public class GridSumFourWays extends GridSum {
    int[][] gridOfMinSums = new int[grid.rows][grid.columns];
    boolean[][] visited = new boolean[grid.rows][grid.columns];

    GridSumFourWays(Grid grid) {
        super(grid);
    }

    @Override
    int[][] gridOfMinSums() {
        // Dijkstra's algorithm
        for (int r = 0; r < grid.rows; r++)
            for (int c = 0; c < grid.columns; c++) {
                gridOfMinSums[r][c] = Integer.MAX_VALUE;
                visited[r][c] = false;
            }

        gridOfMinSums[0][0] = grid.grid[0][0];

        while (true) {
            Node n = currentNode();
            if (n.r == -1) break;
            int sum = gridOfMinSums[n.r][n.c];

            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++) {
                    if (i == j) continue;
                    if (i == -j) continue;

                    int r = n.r + i;
                    int c = n.c + j;
                    if (isOutsideGrid(r, c)) continue;
                    int value = grid.grid[r][c] + sum;
                    if (gridOfMinSums[r][c] > value) {
                        gridOfMinSums[r][c] = value;
                    }
                }
            visited[n.r][n.c] = true;
        }

        return gridOfMinSums;
    }

    private Node currentNode() {
        int foundR = -1;
        int foundC = -1;
        int min = Integer.MAX_VALUE;

        for (int r = 0; r < grid.rows; r++)
            for (int c = 0; c < grid.columns; c++)
                if (!visited[r][c] && gridOfMinSums[r][c] < min) {
                    min = gridOfMinSums[r][c];
                    foundR = r;
                    foundC = c;
                }

        return new Node(foundR, foundC);
    }

    private boolean isOutsideGrid(int r, int c) {
        return c < 0 || c >= grid.columns || r < 0 || r >= grid.rows;
    }

    record Node(int r, int c) {
    }
}
