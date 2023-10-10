package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @BeforeEach
    void setup() {
        task2 = new Task2();
    }

    private Task2 task2;

    @Test
    @DisplayName("Пример из задания")
    void check1() {
        //given
        long number = 544L;
        //when
        int ans = task2.countDigits(number);
        //then
        Assertions.assertThat(ans).isEqualTo(3);
    }

    @Test
    @DisplayName("значение 0")
    void check2() {
        //given
        long number = 0L;
        //when
        int ans = task2.countDigits(number);
        //then
        Assertions.assertThat(ans).isEqualTo(1);
    }

    @Test
    @DisplayName("значение отрицательное")
    void check3() {
        //given
        long number = -5L;
        //when
        int ans = task2.countDigits(number);
        //then
        Assertions.assertThat(ans).isEqualTo(1);
    }

    @Test
    @DisplayName("большое значение")
    void check4() {
        //given
        long number = -7_000_000_000L;
        //when
        int ans = task2.countDigits(number);
        //then
        Assertions.assertThat(ans).isEqualTo(10);
    }

}
