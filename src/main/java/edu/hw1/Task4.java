package edu.hw1;

public class Task4 {

    public String fixString(String inputString) {
        String newString = "";
        char[] inputStringChar = inputString.toCharArray();
        for (int i = 1; i < inputStringChar.length; i += 2) {
            newString += inputStringChar[i];
            newString += inputStringChar[i - 1];
        }
        if (inputStringChar.length % 2 != 0) {
            newString += inputStringChar[inputStringChar.length - 1];
        }
        return newString;
    }

}
