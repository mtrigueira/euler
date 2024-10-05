package utils.data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GridNumber {
    public static short[][] toShortGrid(String number) {
        List<List<Short>> grid = makeGrid(number);
        int rows = grid.size();
        int cols = getCols(grid);
        short[][] a = new short[rows][cols];

        int row = 0;
        for (List<Short> r : grid) {
            int col = 0;
            for (Short s : r) {
                a[row][col] = s;
                col++;
            }
            row++;
        }

        return a;
    }

    private static Integer getCols(List<List<Short>> grid) {
        return grid.stream().map(List::size).max(Integer::compare).orElse(0);
    }

    private static List<List<Short>> makeGrid(String number) {
        List<List<Short>> grid = new ArrayList<>();

        number.lines().forEach(line->{
            List<Short> row = new ArrayList<>();
            Pattern.compile(" ").splitAsStream(line).forEach(token->row.add(Short.parseShort(token)));
            grid.add(row);
        });

        return grid;
    }
}
