package problem.no31to40.problem40;

import utils.sequence.IntegerSequence;
import utils.sequence.arithmetic.ArithmeticNumberSequence;

public class ChampernowneSequence extends ArithmeticNumberSequence<Byte> {
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
