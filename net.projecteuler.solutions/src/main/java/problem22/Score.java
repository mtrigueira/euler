package problem22;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

class Score {
    private final AtomicInteger index = new AtomicInteger(1);

    long score(Stream<String> names) {
        return names.mapToLong(this::nameScore).sum();
    }

    private long nameScore(String name) {
        return NamesScores.nameScore(index.getAndIncrement(), name);
    }
}
