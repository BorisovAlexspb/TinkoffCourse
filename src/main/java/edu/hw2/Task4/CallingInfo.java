package edu.hw2.Task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public record CallingInfo(String className, String methodName) {
    private final static Logger LOGGER = LogManager.getLogger();

    static void callinginfo() {

        StackTraceElement[] st = new Exception().getStackTrace();
        /*for (int i = 0; i < st.length; i++) {

            System.out.println("Index " + i
                + " of stack trace"
                + " array contains = "
                + st[i].toString());
        }*/
        String placeOfCall = st[1].toString();
        LOGGER.info("Function is calling in: " + placeOfCall);
        //System.out.println("Function is calling in: " + placeOfCall);
    }
}
