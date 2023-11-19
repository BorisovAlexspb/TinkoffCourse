package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser6 extends ParserHandler {
    private final static Pattern PATTERN = Pattern.compile("^(\\d{1,10}) (days ago)$");

    @Override
    public Optional<LocalDate> parseDate(String string) {
        Matcher matcher = PATTERN.matcher(string);
        if (matcher.matches()) {
            return Optional.of(LocalDate.now().minusDays(Long.parseLong(matcher.group(1))));
        } else if (nextParser != null) {
            return nextParser.parseDate(string);
        }
        return Optional.empty();
    }
}
