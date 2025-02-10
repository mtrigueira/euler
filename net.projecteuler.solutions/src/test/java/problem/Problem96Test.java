package problem;

import org.junit.jupiter.api.Test;
import utils.FileUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Problem96Test {
    public static final String SIMPLE_STRING = """
            Grid 01
            003020600
            900305001
            001806400
            008102900
            700000008
            006708200
            002609500
            800203009
            005010300""";
    public static final Stream<String> SIMPLE = FileUtils.concat(null, SIMPLE_STRING);

    public static final Stream<String> EASY = FileUtils.concat(null,"""
            Grid 02
            200080300
            060070084
            030500209
            000105408
            000000000
            402706000
            301007040
            720040060
            004010003""");

    public static final Stream<String> HARD = FileUtils.concat(null,"""
            Grid 06
            100920000
            524010000
            000000070
            050008102
            000000000
            402700090
            060000000
            000030945
            000071006""");

    @Test
    void simple() {
        assertEquals(483, Problem96.solution(SIMPLE));
    }

    @Test
    void easy() {
        assertEquals(245,Problem96.solution(EASY));
    }

    @Test
    void hard() {
        assertEquals(176,Problem96.solution(HARD));
    }

    @Test
    void dontAddToEmptySet() {
        assertThrows(UnsupportedOperationException.class, ()-> Problem96.Grid.EMPTY_SET.add((byte)1));
    }

    @Test
    void strings() {
        assertEquals(
                """
                        Grid 01
                        003020600\t       45     4578                49               147              5789       57
                        900305001\t             24678       47                47                78      278        \s
                        001806400\t       25      257                         79                      23579     2357
                        008102900\t      345      345                       3456                      34567    34567
                        700000008\t            123459       49      459    34569        4        1    13456        \s
                        006708200\t     1345    13459                       3459                       1345      345
                        002609500\t      134     1347                        478                       1478       47
                        800203009\t              1467       47               457                17     1467        \s
                        005010300\t       46     4679                 4                47             24678     2467"""
                , new Problem96.Grid(SIMPLE_STRING).toString());
    }
}