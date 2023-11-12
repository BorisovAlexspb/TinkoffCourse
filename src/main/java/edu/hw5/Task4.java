package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(".*[~!@#$%^&*|].*");

    private Task4() {

    }

    public static boolean isPasswordValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        Matcher passwordMatcher = PASSWORD_PATTERN.matcher(password);
        return passwordMatcher.matches();
    }
}
