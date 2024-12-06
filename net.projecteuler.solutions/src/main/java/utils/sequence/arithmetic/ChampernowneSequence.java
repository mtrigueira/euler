package utils.sequence.arithmetic;

public class ChampernowneSequence extends ArithmeticSequence<Byte> {
    private final IntegerSequence integerSequence = new IntegerSequence();
    private String remainingDigits = "";

    @Override
    public Byte next() {
        if (remainingDigits.isEmpty()) {
            remainingDigits = integerSequence.next().toString();
        }
        byte current = Byte.parseByte(remainingDigits.substring(0, 1));
        remainingDigits = remainingDigits.substring(1);
        return current;
    }
}
