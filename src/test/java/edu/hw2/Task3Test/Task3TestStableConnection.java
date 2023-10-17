package edu.hw2.Task3Test;

import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Task3TestStableConnection {
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

}

