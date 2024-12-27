package problem.no51to60;

import utils.prime.Prime;
import utils.prime.PrimeChecker;

import java.util.*;

import static problem.Solution.problem;

public class Problem60 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=60
        problem("Prime pair sets",
                () -> sumOfPrimePairSets(5));
    }

    static long sumOfPrimePairSets(int i) {
        Iterator<Integer> s = Prime.primes.iterator();

        Root root = new Root();

        while (root.depth() <= i)
            root.add(s.next());

        List<Node> nodes = root.depthPath();

        return nodes.stream().mapToLong(node -> node.p).sum();
    }

    static long concat(long a, long b) {
        return (long) (a * Math.pow(10, (b == 0 ? 0 : (int) Math.log10(b)) + 1)) + b;
    }

    static class Root {
        Set<Node> children;

        public void add(long newest) {
            if (children != null)
                for (Node child : children)
                    child.add(newest);
            else {
                children = new HashSet<>(1);
            }

            children.add(new Node(newest));
        }

        public int depth() {
            int depth = 0;

            if (children != null)
                for (Node child : children) {
                    int childDepth = child.depth();
                    if (childDepth > depth)
                        depth = childDepth;
                }

            return depth + 1;
        }

        void depthPath(List<Node> path) {
            int depth = 0;
            Node deepestChild = null;
            if (children != null)
                for (Node child : children) {
                    int childDepth = child.depth();
                    if (childDepth > depth) {
                        depth = childDepth;
                        deepestChild = child;
                    }
                }
            if (deepestChild != null) {
                path.add(deepestChild);
                deepestChild.depthPath(path);
            }
        }

        public List<Node> depthPath() {
            List<Node> path = new ArrayList<>(8);
            depthPath(path);
            return path;
        }
    }

    static class Node extends Root {
        final long p;

        public Node(long p) {
            this.p = p;
        }

        boolean bothConcatenationsArePrime(long b) {
            if (!PrimeChecker.isPrime(concat(p, b)))
                return false;
            return PrimeChecker.isPrime(concat(b, p));
        }

        public void add(long newest) {
            if (!bothConcatenationsArePrime(newest))
                return;
            super.add(newest);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Node node))
                return false;
            return p == node.p;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(p);
        }
    }

    private Problem60() {
    }
}

