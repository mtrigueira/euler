package problem.no51to60;

import utils.prime.Prime;
import utils.prime.PrimeChecker;

import java.util.*;

import static problem.Solution.problem;

public class Problem60 {
    static List<Integer> primesInOrder;

    private Problem60() {
    }

    public static void main(String[] args) {
        // https://projecteuler.net/problem=
        problem("Prime pair sets",
                () -> sumOfPrimePairSets(5));
    }

    static int sumOfPrimePairSets(int i) {
        if (primesInOrder == null)
            primesInOrder = Prime.eratosthenesSieve(9999);

        Iterator<Integer> s = primesInOrder.iterator();
        Node root = new Node();

        while (root.depth() <= i)
            root.add(new Node(s.next()));

        Set<Node> nodes = root.depthPath();

        return nodes.stream().mapToInt(node -> node.p).sum();
    }

    static class Node {
        private static final int ROOT = 0;
        final int p;
        final String pS;
        private final Set<Node> children;

        public Node(int p) {
            this(p, new HashSet<>());
        }

        public Node() {
            this(ROOT, new HashSet<>());
        }

        private Node(int p, Set<Node> children) {
            this.p = p;
            this.children = children;
            pS = p != ROOT ? Integer.toString(p) : "root";
        }

        public Node(Node old) {
            this(old.p, new HashSet<>(old.children));
        }

        boolean bothConcatenationsArePrime(int b) {
            String bS = Integer.toString(b);
            int aConcatB = Integer.parseInt(pS.concat(bS));
            if (!PrimeChecker.isPrime(aConcatB)) return false;
            int bConcatA = Integer.parseInt(bS.concat(pS));
            return PrimeChecker.isPrime(bConcatA);
        }

        public void add(Node newest) {
            if (p != ROOT && !bothConcatenationsArePrime(newest.p)) return;

            for (Node child : children)
                child.add(newest);

            children.add(new Node(newest));
        }

        public int depth() {
            int depth = 0;

            for (Node child : children) {
                int childDepth = child.depth();
                if (childDepth > depth)
                    depth = childDepth;
            }

            return depth + 1;
        }

        public Set<Node> depthPath() {
            Set<Node> path = new HashSet<>();
            depthPath(path);
            return path;
        }

        private void depthPath(Set<Node> path) {
            int depth = 0;
            Node deepestChild = null;
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

        private String toString(String prefix) {
            String s = "";

            for (Node child : children)
                s += prefix + child.toString(prefix + " ");

            return p + s;
        }

        public String toString() {
            return toString("\n ");
        }
    }
}

