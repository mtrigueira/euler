package problem22;

public class NamesScores {
    public static void main(String[] args) {
        System.out.println(forFile("0022_names.txt"));
    }

    static long forFile(String file) {
        return new Score().score(FileUtils.getNames(file));
    }

    static long nameScore(int index, String name) {
        return index * nameWorth(name);
    }

    static long nameWorth(String name) {
        return name.chars().map(NamesScores::scoreChar).sum();
    }

    static int scoreChar(int c) {
        return c - OFFSET_TO_MAP_A_TO_1;
    }

    private static final int OFFSET_TO_MAP_A_TO_1 = 'A' - 1;
}
