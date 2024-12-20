package problem.no81to90;

import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static problem.Solution.problem;

public class Problem84 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=84
        problem("Monopoly odds", () -> new Problem84(6).solution());
    }

    private static final int GO = 0;
    private static final int CC1 = 2;
    private static final int R1 = 5;
    private static final int CH1 = 7;
    private static final int GAOL = 10;
    private static final int C1 = 11;
    private static final int U1 = 12;
    private static final int R2 = 15;
    private static final int CC2 = 17;
    private static final int CH2 = 22;
    private static final int R3 = 25;
    private static final int U2 = 28;
    private static final int G2G = 30;
    private static final int CC3 = 33;
    private static final int CH3 = 36;
    private static final int H2 = 39;
    private static final int TURNS = 2_000_000;
    private static final int E3 = 24;
    private final int sidesOnDie;
    private final int[] tallies = new int[40];
    private Random r;
    private int location;
    private int ccCardPointer;
    private int chCardPointer;
    private int doubles;

    public Problem84(int sidesOnDie) {
        this.sidesOnDie = sidesOnDie;
    }

    String solution() {
        // This uses brute force, consider Markov chain
        r = new Random(1234);
        doubles = 0;

        location = 0;
        ccCardPointer = 0;
        chCardPointer = 0;

        for (int i = 0; i < TURNS; i++) {
            tallies[location]++;

            int redDie = rollDie();
            int greenDie = rollDie();
            move(redDie, greenDie);
        }

        return threeHighestFrequencyLocationsInDecendingOrderWithLeadingZeros();
    }

    private String threeHighestFrequencyLocationsInDecendingOrderWithLeadingZeros() {
        SortedMap<Integer, Integer> tallyLocation = new TreeMap<>();

        for (int i = 0; i < 40; i++)
            tallyLocation.put(tallies[i], i);

        return tallyLocation.reversed().values().stream()
                .limit(3)
                .map(i -> String.format("%02d", i)
                ).collect(Collectors.joining());
    }

    private void move(int redDie, int greenDie) {
        if (redDie != greenDie) {
            doubles = 0;
        } else {
            doubles++;
            if (doubles == 3) {
                doubles = 0;
                location = GAOL;
                return;
            }
        }

        location += redDie + greenDie;
        location = location % 40;
        switch (location) {
            case CC1, CC2, CC3 -> communityChest();
            case CH1, CH2, CH3 -> chance();
            case G2G -> location = GAOL;
        }
    }

    private void chance() {
        switch (chCardPointer % 16) {
            case 0 -> location = GO;
            case 1 -> location = GAOL;
            case 2 -> location = C1;
            case 3 -> location = E3;
            case 4 -> location = H2;
            case 5 -> location = R1;
            case 6, 7 -> nextRailway();
            case 8 -> nextUtility();
            case 9 -> location -= 3;
        }
        chCardPointer = ++chCardPointer % 16;
    }

    private void nextUtility() {
        switch (location) {
            case CH1, CH3 -> location = U1;
//            case CH2 -> location = U2;
            default -> location = U2;
        }
    }

    private void nextRailway() {
        switch (location) {
            case CH1 -> location = R2;
            case CH2 -> location = R3;
//            case CH3 -> location = R1;
            default -> location = R1;
        }
    }

    private void communityChest() {
        switch (ccCardPointer % 16) {
            case 0 -> location = GO;
            case 1 -> location = GAOL;
        }
        ccCardPointer = ++ccCardPointer % 16;
    }

    private int rollDie() {
        return r.nextInt(sidesOnDie) + 1;
    }
}
