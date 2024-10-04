package problem24;

public class LexicographicPermutations {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=24
        System.out.println(permutation(1_000_000, "0123456789"));
    }

    static String permutation(int target, String str) {
        Target t = new Target(target);
        perm("", sorted(str), t);
        return t.str;
    }

    static class Target {
        int count;
        String str = "";

        public Target(int count) {
            this.count = count;
        }

        boolean found(String str) {
            count--;
            if (count == 0) {
                this.str = str;
                count = -1;
            }
            return (count == -1);
        }
    }

    private static boolean perm(String prefix, String str, Target target) {
        if (str.length() == 1)
            return target.found(prefix + str);

        for (int i = 0; i < str.length(); i++)
            if (perm(prefix + str.charAt(i), remove(str, i), target))
                return true;

        return false;
    }

    private static String sorted(String str) {
        return str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    private static String remove(String str, int i) {
        return str.substring(0, i) + str.substring(i + 1);
    }
}
