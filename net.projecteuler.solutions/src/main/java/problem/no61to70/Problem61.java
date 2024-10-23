package problem.no61to70;

import utils.polyagonal.Polygonal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static problem.Solution.problem;
import static problem.Solution.solution;
import static utils.polyagonal.Polygonal.POLYGONALS;

public class Problem61 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=61
        problem("Cyclical figurate numbers");
        solution(cyclicNumbersWithUniqueNagonals(6));
    }

    static int cyclicNumbersWithUniqueNagonals(int count) {
     List<Polygonal> POLYGONAL_LIST = POLYGONALS.subList(0, count);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1000; i <= 9999; i++)
            numbers.add(i);

        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            Integer m = numbers.get(i);
            for (int j = 0; j < numbers.size(); j++) {
                if(i==j) continue;
                Integer n = numbers.get(j);
                if (areCyclic(m, n) && areDifferentPolygonals(POLYGONAL_LIST, m, n)) {
                    pairs.add(new ArrayList<>(List.of(m, n)));
                }
            }
        }
        pairs = pairs.stream().distinct().toList();

        List<List<Integer>> bigCycle = upcycle(pairs, pairs, POLYGONAL_LIST);
        if(count>=4)
            bigCycle = upcycle(bigCycle, pairs, POLYGONAL_LIST);
        if(count>=5)
            bigCycle = upcycle(bigCycle, pairs, POLYGONAL_LIST);
        if(count>=6)
            bigCycle = upcycle(bigCycle, pairs, POLYGONAL_LIST);
        bigCycle = bigCycle.stream().filter(a -> areCyclic(a.get(count-1), a.get(0))).toList();

        bigCycle = bigCycle.stream().filter(a -> a.stream().sorted().findFirst().orElse(-1).equals(a.get(0))).toList();

        bigCycle.stream()
                .peek(a -> dumpDifferentPolygonals(new ArrayList<>(POLYGONAL_LIST), a.toArray(Integer[]::new)))
                .map(List::toString)
                .forEach(System.out::println);

        return bigCycle.stream().findFirst().stream().flatMap(Collection::stream).mapToInt(Integer::intValue).sum();
    }

    private static boolean areDifferentPolygonals(List<Polygonal> polygonals, Integer... m) {
        List<Polygonal> isMPolygonal = polygonals.stream().filter(p -> p.is(BigInteger.valueOf(m[0]))).toList();
        if (polygonals.stream().anyMatch(p -> p.is(BigInteger.valueOf(m[0])))) {
            if (m.length == 1) {
                return true;
            }
            Integer[] newM = new Integer[m.length - 1];
            System.arraycopy(m, 1, newM, 0, m.length - 1);
            for (Polygonal p : isMPolygonal) {
                if (areDifferentPolygonals(polygonals.stream().filter(obj -> !p.equals(obj)).toList(), newM)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean dumpDifferentPolygonals(List<Polygonal> polygonals, Integer... m) {
        List<Polygonal> isMPolygonal = polygonals.stream().filter(p -> p.is(BigInteger.valueOf(m[0]))).toList();
        if (polygonals.stream().anyMatch(p -> p.is(BigInteger.valueOf(m[0])))) {
            if (m.length == 1) {
                System.out.println(m[0] + " is " + polygonals);
                return true;
            }
            Integer[] newM = new Integer[m.length - 1];
            System.arraycopy(m, 1, newM, 0, m.length - 1);
            for (Polygonal p : isMPolygonal) {
                if (dumpDifferentPolygonals(polygonals.stream().filter(obj -> !p.equals(obj)).toList(), newM)) {
                    System.out.println(m[0] + " is " + p);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean areCyclic(Integer m, Integer n) {
        return m % 100 == n / 100;
    }

    static List<List<Integer>> upcycle(List<List<Integer>> cycles, List<List<Integer>> pairs, List<Polygonal> polygonals) {
        List<List<Integer>> out = new ArrayList<>();
        for (List<Integer> cycle : cycles) {
            List<Integer> integers = new ArrayList<>(cycle);
            Integer o = integers.get(integers.size() - 1);
            for (List<Integer> pair : pairs) {
                Integer o2 = pair.get(0);
                if (o.equals(o2)) {
                    List<Integer> m = new ArrayList<>(integers);
                    Integer p = pair.get(1);
                    m.add(p);
                    if (areDifferentPolygonals(polygonals, m.toArray(Integer[]::new))) {
                        out.add(m);
                    }
                }
            }
        }
        out = out.stream().distinct().toList();
        return out;
    }
}
