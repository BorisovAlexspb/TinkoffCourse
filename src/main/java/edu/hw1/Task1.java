package edu.hw1;

public class Task1 {
    final int maxsec = 60;
    final int minlength = 1;

    public int problem(String inputstr) {
        String localStr = inputstr;
        int minute = 0;
        int second = 0;

        String[] splitStr = localStr.split(":");

        if (splitStr.length == minlength) {  // without ":"
            return -1;
        }
        // check if string can not parse to int
        try {
            minute = Integer.parseInt(splitStr[0]);
            second = Integer.parseInt(splitStr[1]);
        } catch (NumberFormatException e) {
            return -1;
        }

        minute = Integer.parseInt(splitStr[0]) * maxsec;
        second = Integer.parseInt(splitStr[1]);
        if (second >= maxsec) {
            return -1;
        }
        return minute + second;
    }
}
