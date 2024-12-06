package utils;

public class Worth {
    private static final int OFFSET_TO_MAP_A_TO_1 = 'A' - 1;

    public static long wordWorth(String name) {
        return name.chars().map(Worth::charWorth).sum();
    }

    static int charWorth(int c) {
        return c - OFFSET_TO_MAP_A_TO_1;
    }

    private Worth() {
    }
}
