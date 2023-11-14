package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task1Test {

    private Task1 task1;

    @BeforeEach
    void setup() {
        task1 = new Task1();
    }

    @Test
    public void oneSessionTest() {
        String res = task1.averageTimeSession("2022-03-12, 20:20 - 2022-03-12, 23:50");
        Assertions.assertThat(res).isEqualTo("3H30M");
    }

    @Test
    public void twoSessionTest() {
        String res =
            task1.averageTimeSession("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20");
        Assertions.assertThat(res).isEqualTo("3H40M");
    }

    @Test
    public void illegalArgumentTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> task1.averageTimeSession(
            "2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30"));
        assertEquals("Illegal argument", exception.getMessage());
    }

    @Test
    public void emptyArgumentTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> task1.averageTimeSession(""));
        assertEquals("Illegal argument", exception.getMessage());
    }
}
