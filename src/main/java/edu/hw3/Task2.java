package edu.hw3;

import java.util.ArrayList;

public class Task2 {

    public ArrayList<String> clusterize(String inputString) {
        ArrayList<String> listOfClasters = new ArrayList<>();
        char[] listOfEl;
        try {
            listOfEl = inputString.toCharArray();
        } catch (Exception e) {
            throw new NullPointerException("Null argument!");
        }
        final int length = listOfEl.length;
        int countOfOpenBracket = 0;
        int countOfCloseBracket = 0;
        int indexR = 0;
        int indexL = 0;
        for (indexR = 0; indexR < length; indexR++) {
            if (listOfEl[indexR] == '(') {
                countOfOpenBracket++;
            }
            if (listOfEl[indexR] == ')') {
                countOfCloseBracket++;
            }
            if (countOfOpenBracket == countOfCloseBracket) {
                listOfClasters.add(inputString.substring(indexL, indexR + 1));
                countOfOpenBracket = 0;
                countOfCloseBracket = 0;
                indexL = indexR + 1;
            }
            if (countOfCloseBracket > countOfOpenBracket) {  // if the order of the brackets is not observed
                listOfClasters.clear();
                break;
            }
        }
        return listOfClasters;
    }
}
