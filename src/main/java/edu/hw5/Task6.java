package edu.hw5;

public class Task6 {

    private Task6() {

    }

    public static boolean isSubstring(String subString, String string) {
        if (subString == null || string == null) {
            throw new IllegalArgumentException("string can't be null");
        }
        char[] chars = subString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".*");
        for (char c : chars) {
            stringBuilder.append("[");
            stringBuilder.append(c);
            stringBuilder.append("]");
            stringBuilder.append(".*");
        }
        return string.matches(stringBuilder.toString());
    }
}
