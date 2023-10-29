package edu.hw3;

import edu.hw3.Task7.MyComparator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

class Task7Test {

    @Test
    void checkNullKey() {
        TreeMap<String, String> tree = new TreeMap<>(new MyComparator());
        tree.put(null, "test");
        Assertions.assertThat(tree.containsKey(null)).isTrue();
    }
}
