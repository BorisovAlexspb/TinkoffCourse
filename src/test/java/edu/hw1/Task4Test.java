package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @BeforeEach
    void setup() {
        task4 = new Task4();
    }
    private Task4 task4;

    @Test
    @DisplayName(" {214365} -> {123456} ")
    void check1() {
        //given
        String str = "214365";
        //when
        String ans = task4.fixString(str);
        //then
        Assertions.assertThat(ans).isEqualTo("123456");
    }

    @Test
    @DisplayName(" {hTsii  s aimex dpus rtni.g} -> {This is a mixed up string.} ")
    void check2() {
        //given
        String str = "hTsii  s aimex dpus rtni.g";
        //when
        String ans = task4.fixString(str);
        //then
        Assertions.assertThat(ans).isEqualTo("This is a mixed up string.");
    }
    @Test
    @DisplayName(" 123 -> 213 ")
    void check3() {
        //given
        String str = "123";
        //when
        String ans = task4.fixString(str);
        //then
        Assertions.assertThat(ans).isEqualTo("213");
    }
    @Test
    @DisplayName(" пустая строка -> пустая строка")
    void check4() {
        //given
        String str = "";
        //when
        String ans = task4.fixString(str);
        //then
        Assertions.assertThat(ans).isEqualTo("");
    }
    @Test
    @DisplayName(" badce -> abcde")
    void check5() {
        //given
        String str = "badce";
        //when
        String ans = task4.fixString(str);
        //then
        Assertions.assertThat(ans).isEqualTo("abcde");
    }
    @Test
    @DisplayName("ab -> ba")
    void check6() {
        //given
        String str = "ab";
        //when
        String ans = task4.fixString(str);
        //then
        Assertions.assertThat(ans).isEqualTo("ba");
    }
    @Test
    @DisplayName("a -> a")
    void check7() {
        //given
        String str = "a";
        //when
        String ans = task4.fixString(str);
        //then
        Assertions.assertThat(ans).isEqualTo("a");
    }
}
