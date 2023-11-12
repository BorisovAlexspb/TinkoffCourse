package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {
    private static final String NULL_MESSAGE = "String can't be null";

    private Task8() {

    }

    //first task
    public static boolean isLengthOdd(String zerosAndOnes) {
        if (zerosAndOnes == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Pattern pattern = Pattern.compile("^[01]([01][01])*$");
        return pattern.matcher(zerosAndOnes).matches();
    }

    //second task
    public static boolean startWithZeroAndOdd(String zerosAndOnes) {
        if (zerosAndOnes == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Pattern pattern = Pattern.compile("^0([01][01])*$");
        return pattern.matcher(zerosAndOnes).matches();
    }

    public static boolean startWithOneAndEven(String zerosAndOnes) {
        if (zerosAndOnes == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Pattern pattern = Pattern.compile("^1[01]([01][01])*$");
        return pattern.matcher(zerosAndOnes).matches();
    }

    public static boolean startWithOneOrNullAndEvenOrOdd(String zerosAndOnes) {
        return (startWithOneAndEven(zerosAndOnes) || startWithZeroAndOdd(zerosAndOnes));
    }

    //fourth task
    public static boolean isNotTwoOrThreeOnesInRow(String zerosAndOnes) {
        if (zerosAndOnes == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Pattern pattern = Pattern.compile("^(?!11$|111$)[01]*");
        return pattern.matcher(zerosAndOnes).matches();
    }

    // fifth task
    public static boolean isEveryOddNumberIsOne(String zerosAndOnes) {
        if (zerosAndOnes == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Pattern pattern = Pattern.compile("^(1[01])*1?$");
        return pattern.matcher(zerosAndOnes).matches();
    }

}
