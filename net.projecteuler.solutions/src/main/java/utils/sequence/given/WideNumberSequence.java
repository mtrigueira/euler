package utils.sequence.given;

public class WideNumberSequence extends DigitNumberSequence {
    final int width;
    public WideNumberSequence(String number, int width) {
        super(number);
        this.width = width;
    }

    @Override
    public Long next() {
        long value = 0;

        for(int i=0;i<width;i++)
            value = value * 10 + digits[index+i];
        index++;

        return value;
    }

    @Override
    public boolean hasNext() {
        return index+width<=digits.length;
    }
}
