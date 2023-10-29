package edu.hw3.Task8;

import java.util.List;
import java.util.ListIterator;

public class BackwardIterator implements ListIterator<Integer> {
    private List<Integer> list;
    int cursor;

    BackwardIterator(List<Integer> list) {
        this.list = list;
        cursor = list.size();
    }

    @Override
    public boolean hasNext() {
        return cursor - 1 >= 0;
    }

    @Override
    public Integer next() {
        cursor -= 1;
        return list.get(cursor);
    }

    @Override
    public boolean hasPrevious() {
        return cursor + 1 < list.size();
    }

    @Override
    public Integer previous() {
        cursor += 1;
        return list.get(cursor);
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Integer integer) {
        throw new UnsupportedOperationException();
    }
}
