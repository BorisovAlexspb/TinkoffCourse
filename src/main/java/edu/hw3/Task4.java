package edu.hw3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task4 {

    final int maxvalue = 4000;
    final int thousand = 1000;
    final int ninehundred = 900;
    final int fivehundred = 500;
    final int fourhundred = 400;
    final int onehundred = 100;
    final int ninety = 90;
    final int fivty = 50;
    final int fourty = 40;
    final int ten = 10;
    final int nine = 9;
    final int five = 5;
    final int four = 4;
    final int one = 1;

    public String convertToRoman(Integer arabNumber) {
        if (arabNumber == null) {
            throw new NullPointerException("Null argument");
        }
        if (!(arabNumber > 0 && arabNumber < maxvalue)) {
            return "Wrong input";
        }

        int localArabNumber = arabNumber;
        String answer = "";

        Map<Integer, String> romanArabNumbers = new LinkedHashMap<>();
        romanArabNumbers.put(thousand, "M");
        romanArabNumbers.put(ninehundred, "CM");
        romanArabNumbers.put(fivehundred, "D");
        romanArabNumbers.put(fourhundred, "CD");
        romanArabNumbers.put(onehundred, "C");
        romanArabNumbers.put(ninety, "XC");
        romanArabNumbers.put(fivty, "L");
        romanArabNumbers.put(fourty, "XL");
        romanArabNumbers.put(ten, "X");
        romanArabNumbers.put(nine, "IX");
        romanArabNumbers.put(five, "V");
        romanArabNumbers.put(four, "IV");
        romanArabNumbers.put(one, "I");

        for (int i : romanArabNumbers.keySet()) {
            if (i > localArabNumber) {
                continue;
            } else {
                localArabNumber -= i;
                answer += romanArabNumbers.get(i);
            }
        }
        while (localArabNumber != 0) {
            localArabNumber--;
            answer += "I";
        }
        return answer;
    }
}
