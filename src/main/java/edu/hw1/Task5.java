package edu.hw1;

import java.util.ArrayList;

public class Task5 {

    public boolean isPalindromeDescendant(long inputNumber) {
        String numberStr = inputNumber + "";
        char[] numberChar = numberStr.toCharArray();
        int lengthOfList = numberChar.length;

        ArrayList<String> numberList = new ArrayList<>();

        for (int i = 0; i < lengthOfList; i++) {   // make an ArrayList
            numberList.add(String.valueOf(numberChar[i]));
        }

        if (isPalindrome(numberList) && lengthOfList > 1) {
            return true;
        }


        while (lengthOfList >= 2) {
            if (isPalindrome(numberList)) {
                return true;
            }
            for (int i = 0; i < lengthOfList - 1; i += 2) {
                int parseInt1;
                int parseInt2;
                parseInt1 = Integer.parseInt(numberList.get(i));
                parseInt2 = Integer.parseInt(numberList.get(i + 1));
                parseInt2 += parseInt1;

                String parseStr = parseInt2 + "";
                numberList.add(parseStr);    // add to the end

            }

            numberList.subList(0, lengthOfList).clear();
            lengthOfList /= 2;
        }
        // check if last element is palindrome
        char[] newNumberChar = numberList.get(0).toCharArray();

        ArrayList<String> newNumberList = new ArrayList<>();
        for (int i = 0; i < newNumberChar.length; i++) {         // make an ArrayList
            newNumberList.add(String.valueOf(newNumberChar[i]));
        }
        if (isPalindrome(newNumberList) && newNumberList.size() > 1) {
            return true;
        }

        return false;

    }

    public boolean isPalindrome(ArrayList<String> numberList) {
        int l = 0;
        int r = numberList.size() - 1;
        while (l < r) {
            if (!(numberList.get(l).equals(numberList.get(r)))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
