package problem;

import org.junit.jupiter.api.Test;
import utils.prime.Prime;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class Problem41Test {
    @Test
    void findPanDigitalPrimes1() {
        assertEquals(Optional.empty(), Problem41.findPanDigitalPrimes(1));
    }

    @Test
    void findPanDigitalPrimes5() {
        assertEquals(Prime.of("4231"), Problem41.findPanDigitalPrimes(5));
    }


}