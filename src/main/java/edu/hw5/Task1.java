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
    private Duration secondsAverage = Duration.ZERO;

    public String averageTimeSession(String... strings) {
        long size = strings.length;
        for (String timeSession : strings) {
            Matcher matcher = SESSION_PATTERN.matcher(timeSession);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Illegal argument");
            } else {
                String[] timeSessionSplit = timeSession.split(" - ");
                LocalDateTime start = LocalDateTime.parse(timeSessionSplit[0], DATE_FORMATTER);
                LocalDateTime end = LocalDateTime.parse(timeSessionSplit[1], DATE_FORMATTER);
                secondsAverage = secondsAverage.plus(Duration.between(start, end));
            }
        }
        return secondsAverage.dividedBy(size).toHoursPart() + "H" + secondsAverage.dividedBy(size).toMinutesPart()
            + "M";
    }
}
