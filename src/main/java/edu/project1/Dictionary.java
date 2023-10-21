package edu.project1;

import java.util.Random;

class Dictionary {
    Random random = new Random();
    private final String[] listWords = {"cat", "tiger", "frog", "elephant", "mouse"};

    public char[] randomWord() {
        int position = random.nextInt(listWords.length);
        String word = listWords[position];
        char[] wordToChar = word.toCharArray();
        return wordToChar;
    }
}
