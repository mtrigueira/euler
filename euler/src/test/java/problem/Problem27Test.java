package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem27Test {
    @Test
    void productOfCoefficientsThatMaximiseConsecutiveValuesThatArePrime() {
        assertEquals(-41, Problem27.productOfCoefficientsThatMaximiseConsecutiveValuesThatArePrime(2, 42));
    }
}