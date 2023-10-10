package edu.hw1;

public class Task2 {
    final long constTen = 10L;

    public int countDigits(long inputNumber) {
        long number = inputNumber;
        int count = 1;
        number /= constTen;
        while (number != 0) {
            count++;
            number /= constTen;
        }
        return count;
    }
}
