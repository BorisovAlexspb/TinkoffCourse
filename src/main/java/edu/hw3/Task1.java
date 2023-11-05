package edu.hw3;

public class Task1 {

    public String atbash(String strToChange) {
        char[] listOfEl;
        final int ASCII_MAX_LOWERCASE_VALUE = 90;
        final int ASCII_MIN_LOWERCASE_VALUE = 65;
        final int ASCII_MIN_UPPERCASE_VALUE = 97;
        final int ASCII_MAX_UPPERCASE_VALUE = 122;
        try {
            listOfEl = strToChange.toCharArray();
        } catch (Exception e) {
            throw new NullPointerException("Null parametr!");
        }
        String listofRes = "";
        for (int i = 0; i < listOfEl.length; i++) {
            char c = listOfEl[i];
            if (c >= ASCII_MIN_LOWERCASE_VALUE && c <= ASCII_MAX_LOWERCASE_VALUE) {
                char newEl = (char) ('Z' - (c - 'A'));
                listofRes += newEl;
            } else if (listOfEl[i] >= ASCII_MIN_UPPERCASE_VALUE && listOfEl[i] <= ASCII_MAX_UPPERCASE_VALUE) {
                char newEl = (char) ('z' - (c - 'a'));
                listofRes += newEl;
            } else {
                listofRes += c;
            }
        }
        return listofRes;
    }
}
