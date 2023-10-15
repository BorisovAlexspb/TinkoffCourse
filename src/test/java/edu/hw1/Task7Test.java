package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @BeforeEach
    void setup(){
        task7 = new Task7();
    }
    private Task7 task7;

    //check rotateRight
    @Test
    @DisplayName("при n == 8 и shift == 1 -> 4")
    void rotateRightcheck1() {
        int n = 8;
        int shift = 1;
        int ans = task7.rotateRight(n, shift);
        Assertions.assertThat(ans).isEqualTo(4);
    }
    @Test
    @DisplayName("при n < 0 -> 1")
    void rotateRightcheck2() {
        int n = -1;
        int shift = 2;
        int ans = task7.rotateRight(n, shift);
        Assertions.assertThat(ans).isEqualTo(-1);
    }
    @Test
    @DisplayName("при n == 1 -> 1 ")
    void rotateRightcheck3() {
        int n = 1;
        int shift = 2;
        int ans = task7.rotateRight(n, shift);
        Assertions.assertThat(ans).isEqualTo(1);
    }
    @Test
    @DisplayName("при shift == 0  -> n (значение не изменится) ")
    void rotateRightcheck4() {
        int n = 4;
        int shift = 0;
        int ans = task7.rotateRight(n, shift);
        Assertions.assertThat(ans).isEqualTo(4);
    }

    // check rotateLeft
    @Test
    @DisplayName("при n == 16 и shift == 1 -> 1")
    void rotateLeftcheck1() {
        int n = 16;
        int shift = 1;
        int ans = task7.rotateLeft(n, shift);
        Assertions.assertThat(ans).isEqualTo(1);
    }
    @Test
    @DisplayName("при n == 17 и shift == 2 -> 1")
    void rotateLeftcheck2() {
        int n = 17;
        int shift = 2;
        int ans = task7.rotateLeft(n, shift);
        Assertions.assertThat(ans).isEqualTo(6);
    }
    @Test
    @DisplayName("при n < 0 -> 1")
    void rotateLeftcheck3() {
        int n = -1;
        int shift = 2;
        int ans = task7.rotateLeft(n, shift);
        Assertions.assertThat(ans).isEqualTo(-1);
    }
    @Test
    @DisplayName("при n == 1 -> 1 ")
    void rotateLeftcheck4() {
        int n = 1;
        int shift = 2;
        int ans = task7.rotateLeft(n, shift);
        Assertions.assertThat(ans).isEqualTo(1);
    }
    @Test
    @DisplayName("при shift == 0  -> n (значение не изменится) ")
    void rotateLeftcheck5() {
        int n = 4;
        int shift = 0;
        int ans = task7.rotateLeft(n, shift);
        Assertions.assertThat(ans).isEqualTo(4);
    }
}
