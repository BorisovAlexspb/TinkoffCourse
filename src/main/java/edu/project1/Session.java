package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;

class Session {

    private Scanner sc;
    private Logger logger;
    private final int maxFailedAttempt = 1;
    private int failedAttempts;
    private boolean check = true;

    // returning the guessed word
    private char[] wordToGuess;
    private char[] stateWord;

    Session(char[] wordToGuess, Scanner sc, Logger logger) { // constructor for normal game
        this.sc = sc;
        this.logger = logger;
        this.wordToGuess = wordToGuess;
        stateWord = makeOfStateWord(wordToGuess.length);

    }

    public void play() {
        if (!checkLengthOfWord(wordToGuess.length)) {
            logger.info("> Incorrect guessed word!");
            check = false;
        }
        while (check) {
            logger.info("> Guess a letter:");
            String gamerInput = sc.next();
            while (!(checkInputLength(gamerInput))) {  // if length of input > 1
                logger.info("> Wrong input!");
                gamerInput = sc.next();
            }
            check = makeMove(gamerInput);
            giveUp();
        }
    }

    boolean makeMove(String gamerInput) {
        if (checkGuess(gamerInput)) {              // correct guess
            logger.info("> Hit!");
            if (isPlayerWin(stateWord)) {
                logger.info("> You win!");
                check = false; // игра закончена
            }
        } else {
            logger.info("> Missed");
            failedAttempts++;
            if (failedAttempts > maxFailedAttempt) {
                logger.info("> You lost :(");
                check = false;
            }
            logger.info("> Mistake " + failedAttempts + " of " + maxFailedAttempt);
        }
        logger.info("> Word is: " + String.valueOf(stateWord));
        return check;
    }

    private boolean checkInputLength(String gamerInput) {
        return gamerInput.length() == 1;
    }

    private boolean checkGuess(String gamerInput) {
        boolean checkForCorrectLetter = false;
        char gamerInputChar = gamerInput.toCharArray()[0];
        for (int i = 0; i < wordToGuess.length; i++) {
            if (wordToGuess[i] == gamerInputChar) {
                stateWord[i] = wordToGuess[i];
                checkForCorrectLetter = true;
            }
        }
        return checkForCorrectLetter;
    }

    private char[] makeOfStateWord(int lengthOfWordToGuess) {   // make a state word like ****
        char[] stateOfWord = new char[lengthOfWordToGuess];
        for (int i = 0; i < stateOfWord.length; i++) {
            stateOfWord[i] = '*';
        }
        return stateOfWord;
    }

    private void giveUp() {
        logger.info("> Want to give up? (yes/no)?");
        if (sc.next().equalsIgnoreCase("yes")) {
            check = false;
        }
    }

    private boolean checkLengthOfWord(int lengthOfWord) {
        return lengthOfWord > 1;
    }

    private boolean isPlayerWin(char[] stateWord) {
        for (int i = 0; i < stateWord.length; i++) {
            if (stateWord[i] == '*') {
                return false;
            }
        }
        return true;
    }
}
