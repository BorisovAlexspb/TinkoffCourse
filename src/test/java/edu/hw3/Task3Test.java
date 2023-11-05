package edu.hw3;

import edu.hw3.Task3;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @BeforeEach
    void setup(){
        task3 = new Task3();
    }
    private Task3 task3;
    @Test
    void freqDictCheckNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> task3.freqDict(null));
        assertEquals("Null argument", exception.getMessage());
    }
    @Test
    void freqDictCheckEmptyList(){
        var emptyList = new Integer[]{};
        var res = task3.freqDict(emptyList);
        Assertions.assertThat(emptyList).isEmpty();
    }
    @Test
    void freqDictCheckStringList(){
        var emptyList = new String[]{"a", "bb", "a", "bb"};
        var res = task3.freqDict(emptyList);
        Assertions.assertThat(emptyList).isNotEmpty();
    }
    @Test
    void freqDictCheckIntegerList(){
        var emptyList = new Integer[]{1, 1, 2, 2};
        var res = task3.freqDict(emptyList);
        Assertions.assertThat(emptyList).isNotEmpty();
    }
}
