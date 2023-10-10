package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @BeforeEach
    void setup() {
        task3 = new Task3();
    }
    private Task3 task3;
    @Test
    @DisplayName("{1,2,3,4} , {0,6} -> true")
    void check1() {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(2);
        first.add(3);
        first.add(4);
        ArrayList<Integer> second = new ArrayList<>();
        second.add(0);
        second.add(6);
        boolean ans = task3.isNestable(first, second);
        Assertions.assertThat(ans).isEqualTo(true);
    }
    @Test
    @DisplayName("{3,1} , {4,0} -> true")
    void check2() {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(3);
        first.add(1);
        ArrayList<Integer> second = new ArrayList<>();
        second.add(4);
        second.add(0);
        boolean ans = task3.isNestable(first, second);
        Assertions.assertThat(ans).isEqualTo(true);
    }
    @Test
    @DisplayName("[9, 9, 8], [8, 9] -> false")
    void check3() {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(9);
        first.add(9);
        first.add(8);
        ArrayList<Integer> second = new ArrayList<>();
        second.add(8);
        second.add(9);
        boolean ans = task3.isNestable(first, second);
        Assertions.assertThat(ans).isEqualTo(false);
    }
    @Test
    @DisplayName("[], [] -> false")
    void check4() {
        ArrayList<Integer> first = new ArrayList<>();

        ArrayList<Integer> second = new ArrayList<>();

        boolean ans = task3.isNestable(first, second);
        Assertions.assertThat(ans).isEqualTo(false);
    }
    @Test
    @DisplayName("[], [8,9] -> false")
    void check5() {
        ArrayList<Integer> first = new ArrayList<>();

        ArrayList<Integer> second = new ArrayList<>();
        second.add(8);
        second.add(9);
        boolean ans = task3.isNestable(first, second);
        Assertions.assertThat(ans).isEqualTo(false);
    }
    @Test
    @DisplayName("[8,9], [] -> false")
    void check6() {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(8);
        first.add(9);
        ArrayList<Integer> second = new ArrayList<>();

        boolean ans = task3.isNestable(first, second);
        Assertions.assertThat(ans).isEqualTo(false);
    }
    @Test
    @DisplayName("[8,9], [8,9] -> false")
    void check7() {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(8);
        first.add(9);
        ArrayList<Integer> second = new ArrayList<>();
        second.add(8);
        second.add(9);
        boolean ans = task3.isNestable(first, second);
        Assertions.assertThat(ans).isEqualTo(false);
    }
}
