package utils.sequence;

class IntegerSequence extends Sequence<Integer> {
    private int i = 0;

    @Override
    public Integer next() {
        i++;
        return i;
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
