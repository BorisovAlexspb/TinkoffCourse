package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;

public class Task3 {
    public boolean isNestable(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        Collections.sort(a1);
        Collections.sort(a2);
        if (!(a1.size() >= 2 && a2.size() >= 2)) {
            return false;
        }
        return (a1.get(0) > a2.get(0)) && (a1.get(a1.size() - 1) < a2.get(a2.size() - 1));
    }
}
