package utils.sequence.given;

import java.util.NoSuchElementException;

public class WideNumberSequence extends DigitNumberSequence {
    final int width;

    public WideNumberSequence(String number, int width) {
        super(number);
        this.width = width;
    }

    @Override
    public Long next() {
        long value = 0;

        for (int i = 0; i < width; i++) {
            if (index+i>=digits.length) throw new NoSuchElementException("Index out of bounds");
            value = value * 10 + digits[index + i];
            if (value < 0) throw new NoSuchElementException("Arithmetic Overflow");
        }
        index++;

        return value;
    }

    @Override
    public boolean hasNext() {
        return index + width <= digits.length;
    }
}
