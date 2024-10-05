package problem.no11to20.problem12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangularTest {
    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,3",
            "3,6",
            "4,10",
            "5,15",
            "6,21",
            "7,28",
            "8,36",
            "9,45",
            "10,55",
            "11,66",
            "12,78",
            "13,91",
            "14,105",
            "15,120",
            "16,136",
            "17,153",
            "18,171",
            "19,190",
            "20,210",
            "21,231"
    })
    void atPosition(int position, int triangle) {
        assertEquals(triangle, Triangular.atPosition(position));
    }
}