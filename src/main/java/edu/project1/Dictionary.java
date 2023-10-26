package edu.project1;

import java.util.Random;

public class Dictionary {
    private Random random = new Random();

    public char[] makeRandomWord() {
        final String[] listWords = {"cat", "tiger", "frog", "elephant", "mouse"};
        int position = random.nextInt(listWords.length);
        String word = listWords[position];
        char[] wordToChar = word.toCharArray();
        return wordToChar;
    }
}
