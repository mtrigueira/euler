package utils.data;

import java.util.Arrays;
import java.util.Set;

public record Group(int a, int b, int c, int sum) {
    public Group(int a, int b, int c) {
        this(a, b, c, a + b + c);
    }

    public Group(String s) {
        this(Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray());
    }

    private Group(int[] array) {
        this(array[0], array[1], array[2]);
    }

    public int compareGroups(Group that) {
        int[] elements = this.toArray();
        int[] minElements = that.toArray();
        for (int i = 0; i < elements.length; i++) {
            int leftE = elements[i];
            int rightE = minElements[i];
            if (leftE != rightE)
                return leftE - rightE;
        }
        return 0;
    }

    public int[] toArray() {
        return new int[]{a, b, c};
    }

    boolean isNextInRing(Group next) {
        return this.c == next.b;
    }

    @Override
    public String toString() {
        return a + "," + b + "," + c;
    }

    public Set<Integer> set() {
        return Set.of(a, b, c);
    }

    public String toCompactString() {
        return "" + a + b + c;
    }
}
