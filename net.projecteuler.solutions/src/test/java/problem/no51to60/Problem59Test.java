package problem.no51to60;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem59Test {
    private static final byte[] ENCRYPTED = {32,7,10,84,30,26,29,12,4,84,13,29,27,24,1,84,9,0,12,79,5,1,2,31,17,11,79,27,25,10,6,79,27,28,10,79,24,14,21,13,79,11,27,8,65};
    @Test
    void decrypt() {
        assertEquals(4189, Problem59.decrypt(ENCRYPTED));
    }
}