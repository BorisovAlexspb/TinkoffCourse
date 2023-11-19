package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private static final Pattern CAR_NUMBER_VALIDATOR = Pattern.compile("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$");

    private Task5() {

    }

    public static boolean isNumberValid(String carNumber) {
        if (carNumber == null) {
            throw new IllegalArgumentException("Car number can't be null");
        }
        Matcher numberMatcher = CAR_NUMBER_VALIDATOR.matcher(carNumber);
        return numberMatcher.matches();
    }
}
