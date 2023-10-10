package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @BeforeEach
    void setup() {
        task5 = new Task5();
    }

    private Task5 task5;

    @Test
    @DisplayName("11211230L -> true ")
    void check1() {
        //given
        long number = 11211230L;
        //when
        boolean ans = task5.isPalindromeDescendant(number);
        //then
        Assertions.assertThat(ans).isEqualTo(true);
    }

    @Test
    @DisplayName("13001120  -> true ")
    void check2() {
        //given
        long number = 13001120L;
        //when
        boolean ans = task5.isPalindromeDescendant(number);
        //then
        Assertions.assertThat(ans).isEqualTo(true);
    }

    @Test
    @DisplayName("23336014  -> true ")
    void check3() {
        //given
        long number = 23336014L;
        //when
        boolean ans = task5.isPalindromeDescendant(number);
        //then
        Assertions.assertThat(ans).isEqualTo(true);
    }

    @Test
    @DisplayName("11 -> true ")
    void check4() {
        //given
        long number = 11L;
        //when
        boolean ans = task5.isPalindromeDescendant(number);
        //then
        Assertions.assertThat(ans).isEqualTo(true);
    }

    @Test
    @DisplayName(" 1 -> false ")
    void check5() {
        //given
        long number = 1L;
        //when
        boolean ans = task5.isPalindromeDescendant(number);
        //then
        Assertions.assertThat(ans).isEqualTo(false);
    }

    @Test
    @DisplayName("нечетная длина + не палиндром -> false")
    void check6() {
        //given
        long number = 123L;
        //when
        boolean ans = task5.isPalindromeDescendant(number);
        //then
        Assertions.assertThat(ans).isEqualTo(false);
    }

    @Test
    @DisplayName("нечетная длина + палиндром -> true")
    void check7() {
        //given
        long number = 111L;
        //when
        boolean ans = task5.isPalindromeDescendant(number);
        //then
        Assertions.assertThat(ans).isEqualTo(true);
    }
}
