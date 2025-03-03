package utils.sequence.given;

import java.util.NoSuchElementException;

public class WideNumberProductSequence extends WideNumberSequence {
    public WideNumberProductSequence(String number, int width) {
        super(number, width);
    }

    @Override
    public Long next() {
        long value = 1;

        for (int i = 0; i < width; i++) {
            if (index+i>=digits.length) throw new NoSuchElementException("Index out of bounds");
            value = value * digits[index + i];
            if (value < 0) throw new NoSuchElementException("Arithmetic Overflow");
        }
        index += 1;

        return value;
    }
}
