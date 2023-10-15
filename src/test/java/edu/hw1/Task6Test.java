package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @BeforeEach
    void setup(){
        task6 = new Task6();
    }
    private Task6 task6;
    @Test
    @DisplayName("6621 -> 5")
    void check1() {
        int number = 6621;
        int ans = task6.kaprekara(number);
        Assertions.assertThat(ans).isEqualTo(5);
    }
    @Test
    @DisplayName("999 -> -1")
    void check2() {
        int number = 999;
        int ans = task6.kaprekara(number);
        Assertions.assertThat(ans).isEqualTo(-1);
    }
    @Test
    @DisplayName("10000 -> -1")
    void check3() {
        int number = 10000;
        int ans = task6.kaprekara(number);
        Assertions.assertThat(ans).isEqualTo(-1);
    }
    @Test
    @DisplayName("2000 -> 4 ")
    void check4() {
        int number = 2000;
        int ans = task6.kaprekara(number);
        Assertions.assertThat(ans).isEqualTo(4);
    }
    @Test
    @DisplayName("1111 -> -1 ")
    void check5() {
        int number = 1111;
        int ans = task6.kaprekara(number);
        Assertions.assertThat(ans).isEqualTo(-1);
    }

    @Test
    @DisplayName("1234 -> 3 ")
    void check6() {
        int number = 1234;
        int ans = task6.kaprekara(number);
        Assertions.assertThat(ans).isEqualTo(3);
    }
}
