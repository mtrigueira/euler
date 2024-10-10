package utils.data;

public class NumberWord {
    private static final String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TEENS = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String of(int number) {
        if(number<1||number>1000) throw new IllegalArgumentException("Number must be between 1 and 1000 inclusive");
        String result = "";

        if(number==1000) return "one thousand";

        int belowHundreds = number % 100;
        int hundreds = number / 100;
        if(number >= 100) {
            result += UNITS[hundreds] + " hundred";
            if(belowHundreds>0)
                result += " and ";
        }

        result += ofTensAndUnits(belowHundreds);
        return result;
    }

    private static String ofTensAndUnits(int number) {
        String result = "";
        if (number >10 && number < 20) {
             result += TEENS[number - 10];
        } else {
            if (number >= 10) {
                int tens = (number / 10) % 10;
                if (tens > 0) {
                    result += TENS[tens];
                    if (number % 10 > 0)
                        result += "-";
                }
            }
            if (number % 10 > 0) {
                result += UNITS[number % 10];
            }
        }
        return result;
    }
}
