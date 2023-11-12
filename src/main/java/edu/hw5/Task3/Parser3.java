package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//2020-12-2
public class Parser3 extends ParserHandler {
    private final static Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d");
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-d");

    @Override
    public Optional<LocalDate> parseDate(String string) {
        Matcher matcher = DATE_PATTERN.matcher(string);
        if (matcher.matches()) {
            LocalDate date = LocalDate.parse(string, DATE_FORMATTER);
            return Optional.of(date);
        } else if (nextParser != null) {
            return nextParser.parseDate(string);
        }
        return Optional.empty();
    }
}
