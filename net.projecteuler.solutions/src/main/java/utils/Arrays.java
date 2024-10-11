package utils;

import utils.sequence.Sequence;

import java.util.ArrayList;

public class Arrays {
    public static <T> T[] makeArray(Sequence<T> seq, int numberOfPrimes) {
        ArrayList<T> list = new ArrayList<>();
        for (int j = 1; j < numberOfPrimes; j++) {
            T divisor = seq.next();
            list.add(divisor);
        }

        @SuppressWarnings("unchecked")
        T[] array = (T[]) list.toArray();
        return array;
    }
}
