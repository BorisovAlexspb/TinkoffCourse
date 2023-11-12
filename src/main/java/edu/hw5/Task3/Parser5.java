package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

@SuppressWarnings("ReturnCount")
public class Parser5 extends ParserHandler {

    @Override
    public Optional<LocalDate> parseDate(String string) {
        switch (string) {
            case "tomorrow" -> {
                return Optional.of(LocalDate.now().plusDays(1));
            }
            case "yesterday" -> {
                return Optional.of(LocalDate.now().minusDays(1));
            }
            case "today" -> {
                return Optional.of(LocalDate.now());
            }
            default -> {
                if (nextParser != null) {
                    return nextParser.parseDate(string);
                }
            }
        }
        return Optional.empty();
    }
}
