package edu.hw1;

public class Task8 {
    final int number2 = 2;
    final int normSize = 10;
    final int maxSize = 12;

    public boolean knightBoardCapture(int[][] desc) {
        // matrix 12 * 12
        int[][] descMax = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        for (int i = number2; i < normSize; i++) {
            for (int j = number2; j < normSize; j++) {
                descMax[i][j] = desc[i - 2][j - 2];
            }
        }
        //System.out.println("good");
        for (int i = number2; i < normSize; i++) {
            for (int j = number2; j < normSize; j++) {
                if (descMax[i][j] == 1) {
                    if (descMax[i - 1][j - 2] == 1
                        || descMax[i + 1][j - 2] == 1
                        || descMax[i - 2][j - 1] == 1
                        || descMax[i + 2][j - 1] == 1
                        || descMax[i - 2][j + 1] == 1
                        || descMax[i + 2][j + 1] == 1
                        || descMax[i - 1][j + 2] == 1
                        || descMax[i + 1][j + 2] == 1
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

}
