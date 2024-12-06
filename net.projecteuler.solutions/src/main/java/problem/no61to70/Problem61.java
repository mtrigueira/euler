package problem.no61to70;

import utils.polyagonal.Polygonal;

import java.math.BigInteger;
import java.util.*;

import static problem.Solution.problem;
import static utils.polyagonal.Polygonal.POLYGONALS;

public class Problem61 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=61
        problem("Cyclical figurate numbers",
                () -> cyclicNumbersWithUniquePolygonals(6));
    }

    static int cyclicNumbersWithUniquePolygonals(int count) {
        List<Polygonal> POLYGONAL_LIST = POLYGONALS.subList(0, count);
        List<Node> numbers = createNodes(POLYGONAL_LIST);

        addNextInChainToNodes(numbers);
        numbers = numbers.stream().filter(n -> !n.nextInChain.isEmpty()).toList();

        List<List<Node>> cycles = findCycles(numbers);

        cycles = cycles.stream().filter(c -> c.size() == count).toList();

        return cycles.get(0).stream().mapToInt(n -> n.i).sum();
    }

    private static List<List<Node>> findCycles(List<Node> nodes) {
        List<List<Node>> cycles = new ArrayList<>();

        for (Node node : nodes) {
            List<List<Node>> chains = chain(node);
            for (List<Node> chain : chains)
                if (isCyclical(chain)) {
                    sortChain(chain);
                    if (!cycles.contains(chain))
                        cycles.add(chain);
                }
        }

        return cycles;
    }

    private static boolean isCyclical(List<Node> chain) {
        return chain.get(chain.size() - 1).nextInChain.contains(chain.get(0));
    }

    private static void sortChain(List<Node> chain) {
        Node min = chain.stream().min(Comparator.comparingInt(a -> a.i)).orElseThrow();
        int minIndex = chain.indexOf(min);

        Collections.rotate(chain, -minIndex);
    }

    private static List<List<Node>> chain(Node node) {
        return chain(node, new ArrayList<>());
    }

    private static List<List<Node>> chain(Node node, List<Node> chain) {
        if (node.nextInChain.isEmpty()) return List.of();
        if (chain.contains(node)) {
            return List.of(chain);
        }
        List<List<Node>> childChains = new ArrayList<>();
        List<Node> newChain = new ArrayList<>(chain);
        newChain.add(node);
        if (areDifferentPolygonals(newChain.toArray(Node[]::new))) {
            for (int i = 0; i < node.nextInChain.size(); i++) {
                List<List<Node>> childChain = chain(node.nextInChain.get(i), newChain);
                if (!childChain.isEmpty()) {
                    childChains.addAll(childChain);
                }
            }
            if (childChains.isEmpty())
                return List.of(newChain);
        }

        return childChains;
    }

    private static void addNextInChainToNodes(List<Node> numbers) {
        for (Node m : numbers)
            for (Node n : numbers) {
                int i = m.i;
                int j = n.i;
                if (i == j) continue;

                if (areChained(i, j))
                    if (areDifferentPolygonals(m, n))
                        m.nextInChain.add(n);
            }
    }

    private static List<Node> createNodes(List<Polygonal> POLYGONAL_LIST) {
        List<Node> numbers = new ArrayList<>();
        for (int i = 1000; i <= 9999; i++) {
            List<Polygonal> list = polygonalsOf(POLYGONAL_LIST, i);
            if (!list.isEmpty())
                numbers.add(new Node(i, list, new ArrayList<>()));
        }
        return numbers;
    }

    private static List<Polygonal> polygonalsOf(List<Polygonal> POLYGONAL_LIST, int i) {
        var b = BigInteger.valueOf(i);
        return POLYGONAL_LIST.stream().filter(p -> p.is(b)).toList();
    }

    static boolean areDifferentPolygonals(Node... m) {
        List<List<Polygonal>> polygonals = Arrays.stream(m).toList().stream().map(n -> n.polygonal).toList();
        List<List<Polygonal>> distinctPolygonals = polygonals.stream().distinct().toList();
        return distinctPolygonals.size() >= m.length;
    }

    private static boolean areChained(Integer m, Integer n) {
        return m % 100 == n / 100;
    }

    public record Node(int i, List<Polygonal> polygonal, List<Node> nextInChain) {
        @Override
        public String toString() {
            return i + " is " + polygonal + ", next " + nextInChain.stream().map(n -> n.i).toList();
        }
    }

    private Problem61() {
    }
}
