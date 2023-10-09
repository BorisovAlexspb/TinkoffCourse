package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @BeforeEach
    void setup() {
        task1 = new Task1();
    }

    private Task1 task1;

    @Test
    @DisplayName("Проверка, где минуты == 0")
    void check1() {
        // given
        String time = "00:23";
        // when
        int ans = task1.problem(time);
        String ansString = ans + "";
        // then
        Assertions.assertThat(ansString).isEqualTo("23");
    }

    @Test
    @DisplayName("Проверка, где секунды == 0")
    void check2() {
        // given
        String time = "23:00";
        // when
        int ans = task1.problem(time);
        String ansString = ans + "";
        // then
        Assertions.assertThat(ansString).isEqualTo("1380");
    }

    @Test
    @DisplayName("неправильный ввод, буквы")
    void check3() {
        // given
        String time = "sfsfvdv";
        // when
        int ans = task1.problem(time);
        String ansString = ans + "";
        // then
        Assertions.assertThat(ansString).isEqualTo("-1");
    }

    @Test
    @DisplayName("нет символа двоеточия (:) ")
    void check4() {
        // given
        String time = "800";
        // when
        int ans = task1.problem(time);
        String ansString = ans + "";
        // then
        Assertions.assertThat(ansString).isEqualTo("-1");
    }

    @Test
    @DisplayName("количество секунд >= 60")
    void check5() {
        // given
        String time = "800:60";
        // when
        int ans = task1.problem(time);
        String ansString = ans + "";
        // then
        Assertions.assertThat(ansString).isEqualTo("-1");
    }

    @Test
    @DisplayName("проверка из условия задачи")
    void check6() {
        // given
        String time = "999:59";
        // when
        int ans = task1.problem(time);
        String ansString = ans + "";
        // then
        Assertions.assertThat(ansString).isEqualTo("59999");
    }
}
