package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class Task2Test {
    private Task2 task2;

    @BeforeEach
    void setup() {
        task2 = new Task2();
    }

    @Test
    void numberOfFridayInYearTest() {
        var res = task2.numberOfFridayInYear(1925);
        Assertions.assertThat(res).isEqualTo(List.of("1925-02-13", "1925-03-13", "1925-11-13"));
    }

    @Test
    void nextFridayInNextYearTest() {
        var res = task2.getNextFridayThirteen(1925, 11, 14);
        Assertions.assertThat(res).isEqualTo("1926-08-13");
    }

    @Test
    void nextFridayInThatYearTest() {
        var res = task2.getNextFridayThirteen(1925, 2, 13);
        Assertions.assertThat(res).isEqualTo("1925-03-13");
    }
}
