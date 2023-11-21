package edu.project3.programFiles;

import edu.project3.programFiles.output.AdocOutputGenerator;
import edu.project3.programFiles.output.MarkdownOutputGenerator;
import edu.project3.programFiles.parser.LogEntry;
import edu.project3.programFiles.parser.PathParser;
import edu.project3.programFiles.receiver.HtttpReceiver;
import edu.project3.programFiles.receiver.PathFileReceiver;
import edu.project3.programFiles.receiver.Receiver;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static edu.project3.programFiles.parser.WebLogParser.parseEntry;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    private String filePath;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String outputFormat;
    private static final String EXCEPTION_MESSAGE = "File not found";
    private static final Pattern URL_PATTERN =
        Pattern.compile("\"^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]\"");
    public static final int LOGS_COUNT = 3;

    public LogAnalyzer(String filePath, LocalDate dateFrom, LocalDate dateTo, String outputFormat) {
        records = new ArrayList<LogEntry>();
        this.filePath = filePath;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.outputFormat = outputFormat;
    }

    public void readFile() throws IOException {

        Receiver receiver;
        Matcher matcher = URL_PATTERN.matcher(filePath);
        if (matcher.matches()) {
            receiver = new HtttpReceiver(filePath);
        } else {
            receiver = new PathFileReceiver(PathParser.getPaths(filePath));
        }
        List<String> fileInString = receiver.receive();
        for (String s : fileInString) {
            records.add(parseEntry(s));
        }
        var totalInfo = totalInfo(numberOfAllRequest(), averageServerResponseSize());
        switch (outputFormat) {
            case "markdown", "" -> new MarkdownOutputGenerator().generate(
                totalInfo,
                mostFrequentlyRequestedResources(),
                mostCommonResponseCodes()
            );
            case "adoc" -> new AdocOutputGenerator().generate(
                totalInfo,
                mostFrequentlyRequestedResources(),
                mostCommonResponseCodes()
            );
            default -> {
            }
        }
    }

    public Long numberOfAllRequest() {
        return (long) records.size();
    }

    public Map<String, Long> mostFrequentlyRequestedResources() {
        var map = records
            .stream()
            .filter(a -> a.getAccessTime().toLocalDate().isAfter(dateFrom)
                && a.getAccessTime().toLocalDate().isBefore(dateTo))
            .collect(
                Collectors.groupingBy(LogEntry::getRequest, Collectors.counting())
            );

        return map.entrySet()
            .stream()
            .sorted((entry1, entry2) -> (int) (entry2.getValue() - entry1.getValue()))
            .limit(LOGS_COUNT)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Integer, Long> mostCommonResponseCodes() {
        var map = records
            .stream()
            .filter(a -> a.getAccessTime().toLocalDate().isAfter(dateFrom)
                && a.getAccessTime().toLocalDate().isBefore(dateTo))
            .collect(
                Collectors.groupingBy(LogEntry::getStatusCode, Collectors.counting())
            );

        return map.entrySet()
            .stream()
            .sorted((entry1, entry2) -> (int) (entry2.getValue() - entry1.getValue()))
            .limit(LOGS_COUNT)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public long averageServerResponseSize() {
        long averageSizeOfBytes = 0;
        for (LogEntry entry : records) {
            int sizeOfBytes = entry.getBytesReturned();
            if (entry.getAccessTime().toLocalDate().isAfter(dateFrom)
                && entry.getAccessTime().toLocalDate().isBefore(dateTo)) {
                averageSizeOfBytes += sizeOfBytes;
            }
        }
        return averageSizeOfBytes / records.size();
    }

    public Map<String, String> totalInfo(Long numberOfRequest, Long averageSizeBytes) {
        Map<String, String> mapTotalInfo = new TreeMap<>();
        mapTotalInfo.put("Файлы", filePath);
        mapTotalInfo.put("Начальная дата", String.valueOf(dateFrom));
        mapTotalInfo.put("Конечная дата", String.valueOf(dateTo));
        mapTotalInfo.put("Количество запросов", String.valueOf(numberOfRequest));
        mapTotalInfo.put("Средний размер ответа", String.valueOf(averageSizeBytes));
        return mapTotalInfo;
    }
}
