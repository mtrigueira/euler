package problem8;

import utils.Sequence;

public class DigitNumber extends Sequence {
    public DigitNumber(String number) {
        this.digits = DigitNumber.toByteArray(number);
    }

    final byte[] digits;
    int index = 0;


    public long next()  {
        long value = 0;
        index++;

        return value;
    }

    public boolean hasNext() {
        return index<digits.length;
    }

    static byte[] toByteArray(String number) {
        byte[] a = new byte[number.length()];

        for(int i=0;i<number.length();i++)
            a[i] = (byte) Character.getNumericValue(number.charAt(i));

        return a;
    }
}
