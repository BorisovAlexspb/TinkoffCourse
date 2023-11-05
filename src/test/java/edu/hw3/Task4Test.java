package edu.hw3;

import edu.hw3.Task4;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @BeforeEach
    void setup(){
        task4 = new Task4();
    }
    private Task4 task4;
    @Test
    void convertToRomanCheckWrongInputNumber() {
        Integer input = -50;
        String res = task4.convertToRoman(input);
        Assertions.assertThat(res).isEqualTo("Wrong input");
    }
    @Test
    void convertToRomanCheckNullException() {
        Throwable exception = assertThrows(NullPointerException.class, () -> task4.convertToRoman(null));
        assertEquals("Null argument", exception.getMessage());
    }
    @Test
    void convertToRomanCheckNormalInput() {
        Integer input = 16;
        String res = task4.convertToRoman(input);
        Assertions.assertThat(res).isEqualTo("XVI");
    }
}
