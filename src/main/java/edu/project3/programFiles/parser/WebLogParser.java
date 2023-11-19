package edu.project3.programFiles.parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class WebLogParser {
    private WebLogParser() {
    }

    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:kk:mm:ss Z", Locale.ENGLISH);
    private static final String EXCEPTION_MESSAGE = "Incorrect data";

    private static String munchTo(StringBuilder sb, String delim) {
        int x = sb.indexOf(delim);
        if (x == -1) {
            x = sb.length();
        }
        String ans = sb.substring(0, x);
        sb.delete(0, x + delim.length());
        return ans;
    }

    public static LogEntry parseEntry(String line) {
        StringBuilder sb = new StringBuilder(line);
        String ip = munchTo(sb, " ");
        munchTo(sb, " "); //ignore -
        munchTo(sb, " ["); //ignore -, and eat the leading [
        String dateStr = munchTo(sb, "] \""); //]-space is intentional: eat both
        LocalDateTime date = parseDate(dateStr);
        String request = munchTo(sb, "\" "); // quote-space is intentional: eat both
        String statusStr = munchTo(sb, " ");
        int status = Integer.parseInt(statusStr);
        String byteStr = munchTo(sb, " ");
        int bytes = Integer.parseInt(byteStr);
        return new LogEntry(ip, date, request, status, bytes);
    }

    public static LocalDateTime parseDate(String dateStr) {
        return LocalDateTime.parse(dateStr, FORMATTER);
    }

    public static LocalDate parseOptionalArgumentDateFrom(String dateStr) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(dateStr);
        } catch (DateTimeParseException e) {
            if (dateStr.isEmpty()) {
                localDate = LocalDate.MIN;
            } else {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
        return localDate;
    }

    public static LocalDate parseOptionalArgumentDateTo(String dateStr) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(dateStr);
        } catch (DateTimeParseException e) {
            if (dateStr.isEmpty()) {
                localDate = LocalDate.MAX;
            } else {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }
        return localDate;
    }
}

