package problem.no21to30.library22;

public class Worth {
    static long nameWorth(String name) {
        return name.chars().map(Worth::charWorth).sum();
    }

    static int charWorth(int c) {
        return c - OFFSET_TO_MAP_A_TO_1;
    }

    private static final int OFFSET_TO_MAP_A_TO_1 = 'A' - 1;
}
