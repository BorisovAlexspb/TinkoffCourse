package edu.hw1;

import java.util.ArrayList;

public class Task3 {

    public boolean isNestable(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        if (!(a1.size() >= 2 && a2.size() >= 2)) {
            return false;
        }

        int minFistList = a1.get(0);
        int maxFirstList = a1.get(0);
        int minSecondList = a2.get(0);
        int maxSecondList = a2.get(0);

        for (int i = 0; i < a1.size(); i++) {
            if (a1.get(i) < minFistList) {
                minFistList = a1.get(i);
            }
            if (a1.get(i) > maxFirstList) {
                maxFirstList = a1.get(i);
            }
        }

        for (int i = 0; i < a2.size(); i++) {
            if (a2.get(i) < minSecondList) {
                minSecondList = a2.get(i);
            }
            if (a2.get(i) > maxSecondList) {
                maxSecondList = a2.get(i);
            }
        }
        if ((minFistList > minSecondList) && (maxFirstList < maxSecondList)) {
            return true;
        }
        return false;
    }
}
