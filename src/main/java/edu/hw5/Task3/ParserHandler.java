package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class ParserHandler {

    protected ParserHandler nextParser;

    public void setNextParser(ParserHandler nextParser) {
        this.nextParser = nextParser;
    }

    public abstract Optional<LocalDate> parseDate(String string);
}

