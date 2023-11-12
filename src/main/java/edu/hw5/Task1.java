package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    private final static Pattern SESSION_PATTERN = Pattern.compile(
        "^(\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}) - (\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2})$");
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
    private double secondsAverage = 0;
    private final static int SECONDS_IN_ONE_HOUR = 3600;
    private final static int MINUTE_IN_ONE_HOUR = 60;

    public String averageTimeSession(String... strings) {
        int size = strings.length;
        for (String timeSession : strings) {
            Matcher matcher = SESSION_PATTERN.matcher(timeSession);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Illegal argument");
            } else {
                String[] timeSessionSplit = timeSession.split(" - ");
                LocalDateTime start = LocalDateTime.parse(timeSessionSplit[0], DATE_FORMATTER);
                LocalDateTime end = LocalDateTime.parse(timeSessionSplit[1], DATE_FORMATTER);
                Duration duration = Duration.between(start, end);
                secondsAverage += duration.getSeconds();
            }
        }
        secondsAverage = secondsAverage / size;
        int minute = (int) (secondsAverage % SECONDS_IN_ONE_HOUR / MINUTE_IN_ONE_HOUR);
        int hours = (int) (secondsAverage / SECONDS_IN_ONE_HOUR);
        return hours + "H" + minute + "M";
    }
}
