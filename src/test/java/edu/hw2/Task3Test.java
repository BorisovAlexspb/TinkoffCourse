package edu.hw2;

import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Task3Test {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void check1() {
        PopularCommandExecutor pce = new PopularCommandExecutor();
        pce.updatePackages("StableConnection");
        String ans = outputStreamCaptor.toString().trim();
        boolean check = ans.contains("Connection is stable");
        org.junit.jupiter.api.Assertions.assertEquals(true, check);
    }

    @Test
    void check2() {
        PopularCommandExecutor pce = new PopularCommandExecutor();
        pce.updatePackages("FaultyConnection");
        String ans = outputStreamCaptor.toString().trim();
        boolean check = ans.contains("error - Runtime Exception");
        org.junit.jupiter.api.Assertions.assertEquals(true, check);
    }
}
