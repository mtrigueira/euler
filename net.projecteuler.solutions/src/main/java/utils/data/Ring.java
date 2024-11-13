package utils.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record Ring(Group[] groups) {
    public static final Ring EMPTY = new Ring();

    public Ring(int... a) {
        this(groupsFromArrayOfInt(a));
    }

    public Ring(Group g) {
        this(new Group[]{g});
    }

    public Ring(Ring ring, Group g) {
        this(getGroups(ring, g));
    }

    private static Group[] getGroups(Ring ring, Group g) {
        Group[] newGroups = Arrays.copyOf(ring.groups, ring.groups.length + 1);
        newGroups[newGroups.length - 1] = g;
        return newGroups;
    }

    private static Group[] groupsFromArrayOfInt(int[] a) {
        int n = a.length / 3;
        Group[] groups = new Group[n];
        for (int i = 0; i < n; i++) {
            groups[i] = new Group(a[i * 3], a[i * 3 + 1], a[i * 3 + 2]);
        }
        return groups;
    }

    public static Ring toRing(int... ring) {
        int n = ring.length / 3;
        Group[] groups = new Group[n];

        for (int i = 0; i < n; i++)
            groups[i] = new Group(ring[i * 3], ring[i * 3 + 1], ring[i * 3 + 2]);

        return new Ring(groups);
    }

    public Ring sort() {
        int minIndex = 0;
        Group[] groups = this.groups;
        for (int i = 1; i < groups.length; i++)
            if (groups[minIndex].compareGroups(groups[i]) > 0)
                minIndex = i;

        for (int i = 0; i < minIndex; i++) {
            Group temp = groups[0];
            for (int j = 1; j < groups.length; j++)
                groups[j - 1] = groups[j];
            groups[groups.length - 1] = temp;
        }

        return new Ring(groups);
    }

    public boolean isMagic() {
        int n = groups.length;
        int magicSum = groups[0].sum();

        for (int i = 1; i < n; i++)
            if (magicSum != groups[i].sum())
                return false;

        return true;
    }

    @Override
    public String toString() {
        return Arrays.stream(groups).map(Group::toString).collect(Collectors.joining(";"));
    }

    public String toCompactString() {
        return Arrays.stream(groups).map(Group::toCompactString).collect(Collectors.joining(""));
    }

    public boolean isRing() {
        if (!isChain()) return false;
        return groups[groups.length - 1].isNextInRing(groups[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ring ring = (Ring) o;
        return Arrays.equals(groups, ring.groups);
    }

    public boolean isChain() {
        int n = groups.length;
        if (n == 1) return true;
        Set<Integer> elements = new HashSet<>(n*2);
        Group g0 = groups[0];
        elements.add(g0.a());
        elements.add(g0.b());
        elements.add(g0.c());

        Group gOld = g0;
        for (int i = 1; i < n - 1; i++) {
            Group gI = groups[i];
            if (!gOld.isNextInRing(gI)) {
                return false;
            } else {
                if (!elements.add(gI.a())) return false;
                // .b() is equal to the previous group .c()
                if (!elements.add(gI.c())) return false;
            }
            gOld = gI;
        }

        return gOld.isNextInRing(groups[n - 1]) && elements.add(groups[n - 1].a());
    }

    public Ring append(Group g) {
        return groups.length == 0 ? new Ring(g) : new Ring(this, g);
    }
}
