package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.Task2.getFactorial;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    @DisplayName("Factorial test")
    public void getFactorialTest(){
        assertEquals(720, getFactorial(6));
        assertEquals(120, getFactorial(5));
    }

    @Test
    @DisplayName("Factorial test -> return exception")
    public void getFactorialTestReturnException() {
        Throwable exception = assertThrows(RuntimeException.class, () -> getFactorial(-1));
        assertEquals("Wrong number", exception.getMessage());
    }
}
