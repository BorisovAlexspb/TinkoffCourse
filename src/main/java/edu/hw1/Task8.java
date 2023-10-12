package edu.hw1;

public class Task8 {
    final int size = 8;

    public boolean knightBoardCapture(int[][] desc) {
        boolean check = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (desc[i][j] == 1) {
                    if (i + 1 < size && j - 2 >= 0) {
                        if (desc[i + 1][j - 2] == 1) {
                            check = false;
                        }
                    }
                    if (i + 2 < size && j - 1 >= 0) {
                        if (desc[i + 2][j - 1] == 1) {
                            check = false;
                        }
                    }
                    if (i + 1 < size && j + 2 < size) {
                        if (desc[i + 1][j + 2] == 1) {
                            check = false;
                        }
                    }
                    if (i + 2 < size && j + 1 < size) {
                        if (desc[i + 2][j + 1] == 1) {
                            check = false;
                        }
                    }
                }
            }
        }
        return check;
    }

}
