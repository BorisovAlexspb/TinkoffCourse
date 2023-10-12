package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task6 {

    final int sizeofnumbers = 4;
    final int degreemax = 3;
    final int number10 = 10;
    final int maxvalue = 9999;
    final int minvalue = 1000;
    final int stoprecursion = 6174;
    int numberForRecursion;

    public int kaprekara(int inputnumber) {

        if (!(inputnumber > minvalue && inputnumber <= maxvalue)) {
            return -1;
        }

        // check if input number contains the same numbers
        char[] numberForCheck = String.valueOf(inputnumber).toCharArray();
        boolean containsSameNumbers = true;
        for (int i = 1; i < numberForCheck.length; i++) {
            if (numberForCheck[i - 1] != numberForCheck[i]) {
                containsSameNumbers = false;
                break;
            }
        }
        if (containsSameNumbers) {
            return -1;
        }

        numberForRecursion = inputnumber;
        int countStep = 0;
        return recursive();
    }

    private int recursive() {
        int countStep = 0;
        if (numberForRecursion == stoprecursion) {
            return countStep;
        }

        Integer[] numberElAsc = new Integer[sizeofnumbers]; // contains digits of ascending numbers
        Integer[] numberElDesc = new Integer[sizeofnumbers]; // contains digits of descending numbers
        for (int i = 0; i < sizeofnumbers; i++) {
            numberElAsc[i] = (int) (numberForRecursion % number10);
            numberElDesc[i] = (int) (numberForRecursion % number10);
            numberForRecursion /= number10;
        }
        Arrays.sort(numberElDesc);
        Arrays.sort(numberElAsc, Collections.reverseOrder());

        int newNumberAsc = 0;
        int newNumberDesc = 0;

        int degree = degreemax;
        for (int j = 0; j < sizeofnumbers; j++) {
            newNumberAsc += numberElAsc[j] * (int) Math.pow(number10, degree);
            newNumberDesc += numberElDesc[j] * (int) Math.pow(number10, degree);
            degree--;
        }
        numberForRecursion = newNumberAsc - newNumberDesc;
        countStep++;
        countStep += recursive();
        return countStep;
    }
}


