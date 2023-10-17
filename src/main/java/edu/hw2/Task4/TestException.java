package edu.hw2.Task4;

public class TestException {

    public void testException1()
        throws Exception {
        testException2();
    }

    // method which throws Exception
    // calling other method testException3
    public void testException2()
        throws Exception {
        CallingInfo.callinginfo();
        testException3();
    }

    // method which throws IndexOutOfBoundsException
    public void testException3()
        throws IndexOutOfBoundsException {
        CallingInfo.callinginfo();
        throw new IndexOutOfBoundsException(
            "Forcefully Generated Exception");
    }

}
