package edu.project1;

class WinnerChecker {
    public boolean isPlayerWin(char[] stateWord) {
        for (int i = 0; i < stateWord.length; i++) {
            if (stateWord[i] == '*') {
                return false;
            }
        }
        return true;
    }
}
