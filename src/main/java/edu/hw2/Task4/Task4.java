package edu.hw2.Task4;

class Task4 {

    private static void main(String[] args)
        throws Exception {
        TestException testexp = new TestException();
        try {
            CallingInfo.callinginfo();
            testexp.testException1();
        } catch (Throwable e) {

        }
    }

    // method which throws Exception
    // calling other method testException2

}
