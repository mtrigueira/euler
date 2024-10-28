package problem.no51to60;

import utils.prime.Prime;
import utils.prime.PrimeChecker;
import utils.sequence.arithmetic.PrimeSequence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static problem.Solution.problem;

public class Problem60 {
    public static void main(String[] args) {
        // https://projecteuler.net/problem=
        problem("Prime pair sets",
        () -> sumOfPrimePairSets(5));
    }

    static int sumOfPrimePairSets(int i) {
        PrimeSequence seq = PrimeSequence.fromFirst();
        Node root = new Node();

        while (root.depthPath().size() < i)
            root.add(new Node(seq.next()));

        List<Node> nodes = root.depthPath();

        return nodes.stream().mapToInt(node -> node.p.intValueExact()).sum();
    }

    static class Node {
        final Prime p;
        private final ArrayList<Node> children;

        public Node(Prime p) {
            this(p, new ArrayList<>());
        }

        public Node() {
            this((Prime) null);
        }

        private Node(Prime p, ArrayList<Node> children) {
            this.p = p;
            this.children = children;
        }

        public Node(Node old) {
            this(old.p, new ArrayList<>(old.children));
        }

        static boolean bothConcatenationsArePrime(Prime a, Prime b) {
            String aS = a.toString();
            String bS = b.toString();

            BigInteger aConcatB = new BigInteger(aS.concat(bS));
            BigInteger bConcatA = new BigInteger(bS.concat(aS));

            return PrimeChecker.isPrime(bConcatA) && PrimeChecker.isPrime(aConcatB);
        }

        public void add(Node newest) {
            if (p != null && !bothConcatenationsArePrime(p, newest.p)) return;

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

        public List<Node> depthPath() {
            List<Node> path = new ArrayList<>();
            depthPath(path);
            return path;
        }

        private void depthPath(List<Node> path) {
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

