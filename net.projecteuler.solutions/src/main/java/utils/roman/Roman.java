package utils.roman;

public class Roman {
    private final int i;

    public static Roman parseRoman(String s) throws NumberFormatException {
        int value = 0;

        StringBuilder sb = new StringBuilder(s);
        RomanDigit left = null;
        int leftCount = 0;
        while (!sb.isEmpty()) {
            char c = sb.charAt(0);
            int rightCount = 0;
            while (!sb.isEmpty() && sb.charAt(0) == c) {
                sb.deleteCharAt(0);
                rightCount++;
            }
            RomanDigit right = RomanDigit.romanDigit(c + "");
            if (left != null)
                if (left.compareTo(right) < 0) {
                    if (leftCount == 1) {
                        //   validate it is a permitted combination
                        value -= left.times(2);
                    } else
                        throw new NumberFormatException("Subtractive may only have one occurrence");

                }

            value += right.times(rightCount);

            left = right;
            leftCount = rightCount;
        }

        return new Roman(value);
    }

    public int intValue() {
        return i;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int r = i;
        while (r > 0) {
            RomanDigit romanDigit = RomanDigit.getMaxFactor(r);
            r -= romanDigit.times(1);
            sb.append(romanDigit);
        }
        return sb.toString();
    }

    private Roman(int i) {
        this.i = i;
    }
}
