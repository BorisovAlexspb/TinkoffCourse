package edu.hw3;

import edu.hw3.Task2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @BeforeEach
    void setup() {
        task2 = new Task2();
    }

    private Task2 task2;
    @Test
    void clusterizeCheckNullException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> task2.clusterize(null));
        assertEquals("Null argument!", exception.getMessage());
    }
    @Test
    void clusterizeCheckEmptyString() {
        String str = "";
        ArrayList<String> ans = task2.clusterize(str);
        Assertions.assertThat(ans).isEmpty();
    }
    @Test
    void clusterizeCheckNormalString() {
        String str = "((()))(())()()(()())";
        ArrayList<String> ans = task2.clusterize(str);
        Assertions.assertThat(ans).isNotEmpty();
    }
}
