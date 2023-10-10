package edu.hw1;

import java.util.ArrayList;

public class Task7 {
    public int rotateRight(int n, int shift) {
        if (!(n > 0 && shift >= 0)) {
            return -1;
        }

        ArrayList<Integer> inSecondSystem = from10TO2(n);
        int size = inSecondSystem.size();

        ArrayList<Integer> afterRShift = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            afterRShift.add(null);
        }

        for (int i = 0; i < size; i++) {
            int position = i + (shift % size);
            if (position >= size) {
                position = position - size;
            }
            afterRShift.set(position, inSecondSystem.get(i));

        }
        return from2TO10(afterRShift);
    }

    public int rotateLeft(int n, int shift) {
        if (!(n > 0 && shift >= 0)) {
            return -1;
        }

        ArrayList<Integer> inSecondSystem = from10TO2(n);
        int size = inSecondSystem.size();

        ArrayList<Integer> afterLShift = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            afterLShift.add(null);
        }

        for (int i = 0; i < size; i++) {
            int position = i - (shift % size);
            if (position < 0) {
                position = size + position;
            }
            afterLShift.set(position, inSecondSystem.get(i));
        }
        //afterLShift.subList(0, shift);
        return from2TO10(afterLShift);
    }

    private ArrayList<Integer> from10TO2(int numberToChange) {
        int localNumberToChange = numberToChange;
        ArrayList<Integer> list = new ArrayList<>();
        while (localNumberToChange != 0) {
            list.add(0, localNumberToChange % 2);
            localNumberToChange /= 2;
        }
        return list;
    }

    private int from2TO10(ArrayList<Integer> listSecondSys) {
        int numbIn10Sys = 0;
        int degree = 0;
        for (int i = listSecondSys.size() - 1; i >= 0; i--) {
            numbIn10Sys += listSecondSys.get(i) * (int) Math.pow(2, degree);
            degree++;
        }
        return numbIn10Sys;
    }
}
