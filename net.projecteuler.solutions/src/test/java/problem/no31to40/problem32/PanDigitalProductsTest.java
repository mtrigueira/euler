package problem.no31to40.problem32;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanDigitalProductsTest {

    @Test
    void squish() {
        List<Integer> combination = List.of(1, 2, 3, 4);
        assertEquals(1, PanDigitalProducts.squish(combination,0,0));
        assertEquals(2, PanDigitalProducts.squish(combination,1,1));
        assertEquals(3, PanDigitalProducts.squish(combination,2,2));
        assertEquals(4, PanDigitalProducts.squish(combination,3,3));
        assertEquals(12, PanDigitalProducts.squish(combination,0,1));
        assertEquals(23, PanDigitalProducts.squish(combination,1,2));
        assertEquals(34, PanDigitalProducts.squish(combination,2,3));
        assertEquals(123, PanDigitalProducts.squish(combination,0,2));
        assertEquals(234, PanDigitalProducts.squish(combination,1,3));
        assertEquals(1234, PanDigitalProducts.squish(combination,0,3));
    }
}