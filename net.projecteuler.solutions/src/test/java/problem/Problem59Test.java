package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem59Test {
    @Test
    void decrypt() {
        assertEquals(4189, Problem59.decrypt(Problem59.ENCRYPTED));
    }
}