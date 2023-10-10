package edu.hw1;

public class Task4 {

    public String fixString(String inputString) {
        String newString = "";
        char[] inputStringChar = inputString.toCharArray();
        for (int i = 0; i < inputStringChar.length; i += 2) {
            if ((i + 1) < inputStringChar.length) {
                newString += inputStringChar[i + 1];
                newString += inputStringChar[i];
            } else {
                newString += inputStringChar[i];
            }
        }
        return newString;
    }

}
