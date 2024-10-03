package problem22;

public class NamesScores {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=22
        System.out.println(forFile("0022_names.txt"));
    }

    static long forFile(String file) {
        return Score.of(FileUtils.getNames(file));
    }
}
