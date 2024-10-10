package utils.data;

public class Range {
    public int start;
    public int end;

    public Range(int start, int end) {
        assert start <= end;
        this.start = start;
        this.end = end;
    }

    static Range range(int start, int end) {
        return new Range(start, end);
    }

    public static Range rangeAbs(int end) {
        return range(-end, end);
    }

    public static Range rangeExclusiveAbs(int end) {
        return rangeAbs(end - 1);
    }
}
