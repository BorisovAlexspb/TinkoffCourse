package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    int countStep = 0;
    final int number4 = 4;
    final int number3 = 3;
    final int number10 = 10;
    final int number1000 = 1000;
    final int number1111 = 1111;
    final int number2222 = 2222;
    final int number3333 = 3333;
    final int number4444 = 4444;
    final int number5555 = 5555;
    final int number6666 = 6666;
    final int number7777 = 7777;
    final int number8888 = 8888;
    final int number9999 = 9999;
    final int number6174 = 6174;

    public int kaprekara(int inputnumber) {

        if (!(inputnumber > number1000 && inputnumber <= number9999)) {
            return -1;
        }

        boolean res = switch (inputnumber) {
            case number1111, number2222, number3333, number4444, number5555,
                 number6666, number7777, number8888, number9999 -> false;
            default -> true;
        };
        if (!res) {
            return -1;
        }

        int number = inputnumber;
        return recursive(number);
    }

    private int recursive(int inputnumber) {
        int number = inputnumber;
        if (number == number6174) {
            return countStep;
        }
        int size = number4;
        Integer[] numberElAsc = new Integer[size]; // contains digits of ascending numbers
        Integer[] numberElDesc = new Integer[size]; // contains digits of descending numbers
        for (int i = 0; i < size; i++) {
            numberElAsc[i] = (int) (number % number10);
            numberElDesc[i] = (int) (number % number10);
            number /= number10;
        }
        Arrays.sort(numberElDesc);
        Arrays.sort(numberElAsc, Collections.reverseOrder());

        int newNumberAsc = 0;
        int newNumberDesc = 0;

        int degree = number3;
        for (int j = 0; j < size; j++) {
            newNumberAsc += numberElAsc[j] * (int) Math.pow(number10, degree);
            newNumberDesc += numberElDesc[j] * (int) Math.pow(number10, degree);
            degree--;
        }
        number = newNumberAsc - newNumberDesc;
        countStep++;
        recursive(number);
        return countStep;
    }
}


