package edu.hw1;

import java.util.ArrayList;

public class Task7 {
    public int rotateRight(int n, int shift) {
        if (!(n > 0 && shift >= 0)) {
            return -1;
        }

        char[] inSecondSystem = Integer.toBinaryString(n).toCharArray(); // to binary system
        int size = inSecondSystem.length;

        ArrayList<String> afterRShift = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            afterRShift.add(null);
        }

        for (int i = 0; i < size; i++) {
            int position = i + (shift % size);
            if (position >= size) {
                position = position - size;
            }
            afterRShift.set(position, String.valueOf(inSecondSystem[i]));
        }
        String strResult = "";
        for (int i = 0; i < afterRShift.size(); i++) {
            strResult += afterRShift.get(i);
        }
        return Integer.parseInt(strResult, 2);
    }

    public int rotateLeft(int n, int shift) {
        if (!(n > 0 && shift >= 0)) {
            return -1;
        }

        char[] inSecondSystem = Integer.toBinaryString(n).toCharArray(); // to binary system
        int size = inSecondSystem.length;

        ArrayList<String> afterLShift = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            afterLShift.add(null);
        }

        for (int i = 0; i < size; i++) {
            int position = i - (shift % size);
            if (position < 0) {
                position = size + position;
            }
            afterLShift.set(position, String.valueOf(inSecondSystem[i]));
        }
        String strResult = "";
        for (int i = 0; i < afterLShift.size(); i++) {
            strResult += afterLShift.get(i);
        }
        return Integer.parseInt(strResult, 2);
    }

}
