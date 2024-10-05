package problem.no21to30.problem27;

class Range {
    int start;
    int end;

    public Range(int start, int end) {
        assert start <= end;
        this.start = start;
        this.end = end;
    }

    static Range range(int start, int end) {
        return new Range(start, end);
    }

    static Range rangeAbs(int end) {
        return range(-end, end);
    }

    static Range rangeExclusiveAbs(int end) {
        return rangeAbs(end - 1);
    }
}
