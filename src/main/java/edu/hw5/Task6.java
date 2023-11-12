package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    private Task6() {

    }

    public static boolean isSubstring(String subString, String string) {
        if (subString == null || string == null) {
            throw new IllegalArgumentException("string can't be null");
        }

        Pattern substringPattern = Pattern.compile(subString);
        Matcher substringMatcher = substringPattern.matcher(string);
        return substringMatcher.find();
    }
}
