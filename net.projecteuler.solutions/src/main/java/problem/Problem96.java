package problem;

import utils.FileUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static problem.Solution.problem;


public class Problem96 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=96
        problem("Su Doku", () ->
                solution(PUZZLES));
    }

    public static final Stream<String> PUZZLES = FileUtils.concat(FileUtils.getStrings("/difficult.txt"), """
            003020600
            900305001
            001806400
            008102900
            700000008
            006708200
            002609500
            800203009
            005010300""");

    static int solution(Stream<String> file) {
        Stream<Grid> gridStream = file.map(PuzzleMaker.from()::line).filter(grid -> Grid.NIL != grid);
        return gridStream.mapToInt(grid -> {
            grid.solve();
            return grid.checkSum();
        }).sum();
    }

    static class Grid {
        public static final HashSet<Byte> EMPTY_SET = new HashSet<>() {
            @Override
            public boolean add(Byte i) {
                throw new UnsupportedOperationException("Shouldn't be trying to add things to the empty set");
            }
        };
        static final Grid NIL = null;
        private static final Set<Byte> CANDIDATES = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().map(Integer::byteValue).collect(Collectors.toSet());
        final byte[] puzzle = new byte[81];
        private final byte depth;
        Leftovers leftovers = new Leftovers();
        private String name;

        Grid(String puzzleString) {
            this.depth = 0;
            byte r = -1;
            for (String line : puzzleString.lines().toList()) {
                if (r == -1) {
                    name = line;
                    r++;
                    continue;
                }
                byte c = 0;
                for (int i : line.chars().toArray()) {
                    puzzle[Point.offset(r, c++)] = (byte) (i - '0');
                }
                r++;
            }
            calculateLeftovers();
        }

        public Grid(byte depth) {
            this.depth = depth;
        }

        private void calculateLeftovers() {
            leftovers.clear();
            for (Point p : Point.all())
                if (puzzle[p.o] == 0)
                    leftovers.put(p, leftovers(p));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append('\n');
            for (byte r = 0; r < 9; r++) {
                for (byte c = 0; c < 9; c++)
                    sb.append(puzzle[Point.offset(r, c)]);
                sb.append('\t');
                for (byte c = 0; c < 9; c++)
                    sb.append(String.format("%9s", leftovers.at(r, c).toString().replaceAll("[\\[\\], ]", "")));
                if (r < 8)
                    sb.append('\n');
            }
            return sb.toString();
        }

        private boolean solveByDeduction(Point p) {
            for (Byte b : leftovers(p))
                if (noOtherValueInBoxCouldBe(p, b)
                        || noOtherValueInColumnCouldBe(p, b)
                        || noOtherValueInRowCouldBe(p, b)) {
                    assign(p, b);
                    return true;
                }

            return false;
        }

        private boolean noOtherValueInRowCouldBe(Point p, Byte b) {
            for (Point q : p.row())
                if (leftovers.at(q).contains(b))
                    return false;

            return true;
        }

        private boolean noOtherValueInColumnCouldBe(Point p, Byte b) {
            for (Point q : p.col())
                if (leftovers.at(q).contains(b))
                    return false;

            return true;
        }

        private boolean noOtherValueInBoxCouldBe(Point p, byte b) {
            for (Point q : p.box())
                if (leftovers.at(q).contains(b))
                    return false;

            return true;
        }

        private void solveByTrialAndError() {
            SortedMap<Byte, Set<Point>> sortedLeftovers = sortedLeftovers();
            if (depth > 1)
                return;
            Grid grid = new Grid((byte) (depth + 1));

            for (Iterator<Set<Point>> iterator = sortedLeftovers.values().iterator(); iterator.hasNext(); ) {
                Set<Point> points = iterator.next();
                for (Point point : points)
                    for (byte leftover : leftovers.at(point)) {
                        copyArray(puzzle, grid.puzzle);

                        grid.name = name + " " + point + "=" + leftover;

                        grid.assign(point, leftover);
                        grid.calculateLeftovers();

                        grid.solve();
                        if (grid.isSolved()) {
                            copyArray(grid.puzzle, puzzle);
                            leftovers = grid.leftovers;
                            iterator.forEachRemaining(ignore->{});
                        }
                    }
            }
        }

        private void copyArray(byte[] from, byte[] to) {
            System.arraycopy(from, 0, to, 0, 9 * 9);
        }

        private SortedMap<Byte, Set<Point>> sortedLeftovers() {
            SortedMap<Byte, Set<Point>> map = new TreeMap<>();
            for (var e : leftovers.entrySet()) {
                Set<Point> points = map.computeIfAbsent((byte) e.getValue().size(), k -> new HashSet<>());
                points.add(e.getKey());
            }
            return map;
        }

        private boolean solveByOnlyPossibleDigit(Point p) {
            Set<Byte> set = leftovers.at(p);
            if (set.size() == 1) {
                Byte value = (Byte) set.toArray()[0];
                assign(p, value);
                return true;
            }
            return false;
        }

        private void assign(Point p, Byte value) {
            puzzle[p.o] = value;
            leftovers.remove(p);

            for (Point q : p.row())
                leftovers.remove(q.r, q.c, value);

            for (Point q : p.col())
                leftovers.remove(q.r, q.c, value);

            for (Point q : p.box())
                leftovers.remove(q.r, q.c, value);
        }

        private Set<Byte> leftovers(Point p) {
            Set<Byte> peers = new HashSet<>();
            allPeers(p, peers);
            return leftovers(peers);
        }

        private void allPeers(Point p, Set<Byte> digits) {
            digitsInBox(p, digits);
            digitsInRow(p, digits);
            digitsInColumn(p, digits);
        }

        private void digitsInColumn(Point p, Set<Byte> digits) {
            for (Point q : p.col())
                digits.add(puzzle[q.o]);
        }

        private void digitsInRow(Point p, Set<Byte> digits) {
            for (Point q : p.row())
                digits.add(puzzle[q.o]);
        }

        private void digitsInBox(Point p, Set<Byte> peers) {
            for (Point q : p.box())
                peers.add(puzzle[q.o]);
        }

        private Set<Byte> leftovers(Set<Byte> digits) {
            Set<Byte> leftovers = new HashSet<>(CANDIDATES);
            leftovers.removeAll(digits);
            return leftovers;
        }

        public void round() {
            for (Point p : leftovers.keySet())
                if (solveByOnlyPossibleDigit(p))
                    return;

            for (Point p : leftovers.keySet())
                if (solveByDeduction(p))
                    return;
        }

        public void solve() {
            int lastOutstanding = leftovers.size() + 1;

            while (leftovers.size() < lastOutstanding) {
                lastOutstanding = leftovers.size();
                round();

                if (!isValid())
                    return;
            }

            if (isSolved())
                return;

            solveByTrialAndError();
        }

        private boolean isValid() {
            for (byte a = 0; a < 9; a++)
                for (byte b = 0; b < 9; b++)
                    if (puzzle[Point.offset(a, b)] == 0)
                        if (!leftovers.containsKey(a, b))
                            return false;

            return true;
        }

        private boolean isSolved() {
            return leftovers.isEmpty();
        }

        public int checkSum() {
            return puzzle[0] * 100 + puzzle[1] * 10 + puzzle[2];
        }

        private static class Leftovers extends HashMap<Point, Set<Byte>> {
            Set<Byte> at(Point p) {
                return getOrDefault(p, EMPTY_SET);
            }

            Set<Byte> at(byte r, byte c) {
                return at(Point.at(r, c));
            }

            void remove(byte r, byte c, Byte remove) {
                Set<Byte> set = getOrDefault(Point.at(r, c), EMPTY_SET);
                set.remove(remove);
                if (set.isEmpty())
                    remove(Point.at(r, c));
            }

            public boolean containsKey(byte r, byte c) {
                return containsKey(Point.at(r, c));
            }
        }
    }

    private static class PuzzleMaker {
        private final StringBuilder sb = new StringBuilder();
        private int lineCounter = 0;

        private PuzzleMaker() {}

        private static PuzzleMaker from() {
            return new PuzzleMaker();
        }

        Grid line(String line) {
            lineCounter++;
            lineCounter %= 10;

            sb.append(line);
            if (lineCounter == 0) {
                Grid grid = new Grid(sb.toString());
                sb.setLength(0);
                return grid;
            } else
                sb.append('\n');

            return Grid.NIL;
        }
    }

    record Point(byte o, byte r, byte c) {
        static final Point[] points;
        private static final Point[][] rows, cols, boxes;

        static {
            points = new Point[81];
            rows = new Point[81][8];
            cols = new Point[81][8];
            boxes = new Point[81][8];
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    points[r * 9 + c] = new Point((byte) (r * 9 + c), (byte) r, (byte) c);
                }
            }
            for (int o = 0; o < 81; o++) {
                Point p = points[o];
                System.arraycopy(p.calcCol(), 0, cols[o], 0, 8);
                System.arraycopy(p.calcRow(), 0, rows[o], 0, 8);
                System.arraycopy(p.calcBox(), 0, boxes[o], 0, 8);
            }
        }

        static Point at(byte r, byte c) {
            return points[offset(r, c)];
        }

        static int offset(byte r, byte c) {
            return r * 9 + c;
        }

        public static Point[] all() {
            return points;
        }

        private Point[] calcRow() {
            Point[] peers = new Point[8];

            for (int x = 0, a = 0; x < 9; x++)
                if (x != c)
                    peers[a++] = points[r * 9 + x];

            return peers;
        }

        private Point[] calcCol() {
            Point[] peers = new Point[8];

            for (int y = 0, a = 0; y < 9; y++)
                if (y != r)
                    peers[a++] = points[y * 9 + c];

            return peers;
        }

        private Point[] calcBox() {
            Point[] peers = new Point[8];
            int top = r / 3 * 3;
            int left = c / 3 * 3;

            for (int y = 0, a = 0; y < 3; y++)
                for (int x = 0; x < 3; x++)
                    if (!((top + y) == r && (left + x) == c))
                        peers[a++] = points[(top + y) * 9 + left + x];

            return peers;
        }

        @Override
        public String toString() {
            return "(" + r + ":" + c + ')';
        }

        public Point[] row() {
            return rows[o];
        }

        public Point[] col() {
            return cols[o];
        }

        public Point[] box() {
            return boxes[o];
        }
    }

    private Problem96() {}
}

