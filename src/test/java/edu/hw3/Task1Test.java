package edu.hw3;

import edu.hw3.Task1;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertThrows;

class Task1Test {

    @BeforeEach
    void setup() {
        task1 = new Task1();
    }

   private Task1 task1;
    @Test
    void atbashCheckEmptyString() {
        String str = "";
        String ans = task1.atbash(str);
        Assertions.assertThat(ans).isEqualTo("");
    }
    @Test
    void atbashCheckNullParametr() {
        Throwable exception = assertThrows(NullPointerException.class, () -> task1.atbash(null));
        assertEquals("Null parametr!", exception.getMessage());
    }
    @Test
    void atbashCheckNormalString() {
        String str = "Hello world!";
        String ans = task1.atbash(str);
        Assertions.assertThat(ans).isEqualTo("Svool dliow!");
    }
}
