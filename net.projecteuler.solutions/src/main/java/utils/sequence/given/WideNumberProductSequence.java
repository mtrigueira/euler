package utils.sequence.given;

public class WideNumberProductSequence extends WideNumberSequence {
    public WideNumberProductSequence(String number, int width) {
        super(number, width);
    }

    @Override
    public Long next() {
        long value = 1;

        for (int i = 0; i < width; i++)
            value = value * digits[index + i];
        index += 1;

        return value;
    }
}
