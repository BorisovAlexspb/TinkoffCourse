package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    List<String> dateOfFriday = new ArrayList<>();
    private final static int DAY_OF_FRIDAY = 13;
    private final static int MONTHS_IN_YEAR = 12;

    public List<String> numberOfFridayInYear(int year) {
        for (int month = 1; month <= MONTHS_IN_YEAR; month++) {
            LocalDate date = LocalDate.of(year, month, DAY_OF_FRIDAY);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek.toString().equals("FRIDAY")) {
                dateOfFriday.add(date.toString());
            }
        }
        return dateOfFriday;
    }

    public String getNextFridayThirteen(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        String ans = "";
        while (true) {
            LocalDate nextFriday = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            if (nextFriday.getDayOfMonth() == DAY_OF_FRIDAY) {
                ans = nextFriday.toString();
                break;
            } else {
                date = LocalDate.of(nextFriday.getYear(), nextFriday.getMonth(), nextFriday.getDayOfMonth());
            }
        }
        return ans;
    }
}
