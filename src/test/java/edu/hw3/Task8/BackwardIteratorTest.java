package edu.hw3.Task8;

import edu.hw3.Task8.BackwardIterator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BackwardIteratorTest {

    @Test
    void nextCheck() {
        BackwardIterator iterator = new BackwardIterator(List.of(1,2,3,4));
        int suggest = 3;
        int res = iterator.next();
        res = iterator.next();
        Assertions.assertThat(suggest).isEqualTo(res);
    }

    @Test
    void HasnextCheck() {
        BackwardIterator iterator = new BackwardIterator(List.of(1,2,3,4));
        Assertions.assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void hasPrevious() {
        BackwardIterator iterator = new BackwardIterator(List.of(1,2,3,4));
        Assertions.assertThat(iterator.hasPrevious()).isFalse();
    }

    @Test
    void previous() {
        BackwardIterator iterator = new BackwardIterator(List.of(1,2,3,4));
        int suggest = 4;
        int res = iterator.next();
        res = iterator.next();
        res = iterator.previous();
        Assertions.assertThat(suggest).isEqualTo(res);
    }
}
