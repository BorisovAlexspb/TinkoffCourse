package edu.hw3;

import java.util.ArrayList;

public class Task1 {
    public String atbash(String strToChange) {
        char[] listOfEl;
        final int ninteen = 90;
        final int sixtyfive = 65;
        final int ninteseven = 97;
        final int hundredndwentytwo = 122;
        try {
            listOfEl = strToChange.toCharArray();
        } catch (Exception e) {
            throw new NullPointerException("Null parametr!");
        }
        ArrayList<String> listOfResult = new ArrayList<>();
        String listofRes = "";
        for (int i = 0; i < listOfEl.length; i++) {
            if (listOfEl[i] >= sixtyfive && listOfEl[i] <= ninteen) {
                char newEl = (char) (ninteen - (listOfEl[i] - sixtyfive));
                String changeLetter = String.valueOf(newEl);
                listOfResult.add(changeLetter);
                listofRes += newEl;
            } else if (listOfEl[i] >= ninteseven && listOfEl[i] <= hundredndwentytwo) {
                char newEl = (char) (hundredndwentytwo - (listOfEl[i] - ninteseven));
                String changeLetter = String.valueOf(newEl);
                listOfResult.add(changeLetter);
                listofRes += newEl;
            } else {
                String sameLetter = String.valueOf(listOfEl[i]);
                listOfResult.add(sameLetter);
                listofRes += listOfEl[i];
            }
        }
        return listofRes;
    }
}
