package edu.hw2.Task3.Exception;

public class ConnectionIsNotStableException extends RuntimeException {
    public ConnectionIsNotStableException(String message) {
        super(message);
    }

    public ConnectionIsNotStableException(String message, Throwable cause) {
        super(message, cause);
    }
}
