package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Session {

    Scanner sc = new Scanner(System.in);
    Dictionary dict = new Dictionary();
    WinnerChecker winnerchecker = new WinnerChecker();
    private final static Logger LOGGER = LogManager.getLogger();
    private final int usualMaxFailedAttempt = 5;
    private int maxFailedAttempt = usualMaxFailedAttempt;
    private int failedAttempts;
    private boolean check = true;

    // returning the guessed word
    private char[] wordToGuess = dict.randomWord();
    private char[] stateWord = makeOfStateWord(wordToGuess.length);

     Session(int maxFailedAttempt, char[] wordToGuess, char[] stateWord) { // constructor for testing
        this.maxFailedAttempt = maxFailedAttempt;
        this.wordToGuess = wordToGuess;
        this.stateWord = stateWord;
    }

    Session() { // constructor for normal game
    }

    public void play() {
        if (!checkLengthOfWord(wordToGuess.length)) {
            LOGGER.info("> Incorrect guessed word!");
            check = false;
        }
        while (check) {
            LOGGER.info("> Guess a letter:");
            String gamerInput = sc.next();
            while (!(gamerGuess(gamerInput))) {  // if length of input > 1
                LOGGER.info("> Wrong input!");
                gamerInput = sc.next();
            }
            check = makeMove(gamerInput);
            giveUp();
        }
    }

    boolean makeMove(String gamerInput) {
        if (checkGuess(gamerInput)) {              // correct guess
            LOGGER.info("> Hit!");
            if (winnerchecker.isPlayerWin(stateWord)) {
                LOGGER.info("> You win!");
                check = false; // игра закончена
            }
        } else {
            LOGGER.info("> Missed");
            failedAttempts++;
            if (failedAttempts > maxFailedAttempt) {
                LOGGER.info("> You lost :(");
                check = false;
            }
            LOGGER.info("> Mistake " + failedAttempts + " of " + maxFailedAttempt);
        }
        LOGGER.info("> Word is: " + String.valueOf(stateWord));
        return check;
    }

    private boolean gamerGuess(String gamerInput) {
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
        //System.out.println(stateOfWord);
        return stateOfWord;
    }

    private void giveUp() {
        LOGGER.info("> Want to give up? (yes/no)?");
        if (sc.next().equalsIgnoreCase("yes")) {
            check = false;
        }
    }

    private boolean checkLengthOfWord(int lengthOfWord) {
        return lengthOfWord > 1;
    }
}
