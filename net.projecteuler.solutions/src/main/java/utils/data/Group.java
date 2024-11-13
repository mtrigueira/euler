package utils.data;

import java.util.Set;

public record Group(int a, int b, int c, int sum) {
    public Group(int a, int b, int c) {
        this(a, b, c, a + b + c);
    }

    public static Group from(String s) {
        int aI = s.indexOf(',');
        int bI = s.indexOf(',', aI + 1);
        return new Group(Integer.parseInt(s.substring(0, aI)),
                Integer.parseInt(s.substring(aI + 1, bI)),
                Integer.parseInt(s.substring(bI + 1)));
    }

    public int compareGroups(Group that) {
        int t = this.a - that.a;
        if (t != 0) return t;
        t = this.b - that.b;
        if (t != 0) return t;
        return this.c - that.c;
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
        return Integer.toString(a) + b + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;
        return a == group.a && b == group.b && c == group.c && sum == group.sum;
    }

    @Override
    public int hashCode() {
        return sum;
    }
}
