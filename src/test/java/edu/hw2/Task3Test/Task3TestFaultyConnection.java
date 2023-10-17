package edu.hw2.Task3Test;

import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Task3TestFaultyConnection {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void check() {
        PopularCommandExecutor pce = new PopularCommandExecutor();
        pce.updatePackages("FaultyConnection");
        String ans = outputStreamCaptor.toString().trim();
        boolean check = ans.contains("error - Runtime Exception");
        org.junit.jupiter.api.Assertions.assertEquals(true, check);
    }
}
