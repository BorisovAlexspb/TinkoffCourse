package edu.project3.programFiles;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static edu.project3.programFiles.parser.WebLogParser.parseOptionalArgumentDateFrom;
import static edu.project3.programFiles.parser.WebLogParser.parseOptionalArgumentDateTo;


@SuppressWarnings("UncommentedMain")
public class Runner {

    public void readFile() {

    }

    public void parseAndStartLogAnalyzer(List<String> arguments) throws IOException {
        String filePath = "";
        String dateFrom = "";
        String dateTo = "";
        String outputFormat = "";
        for (int i = 0; i < arguments.size(); i++) {
            if (arguments.get(i).equals("--path")) {
                filePath = arguments.get(i + 1);
            }
            if (arguments.get(i).equals("--from")) {
                dateFrom = arguments.get(i + 1);
            }
            if (arguments.get(i).equals("--to")) {
                dateTo = arguments.get(i + 1);
            }
            if (arguments.get(i).equals("--format")) {
                outputFormat = arguments.get(i + 1);
            }
        }
        LocalDate parseDateFrom = parseOptionalArgumentDateFrom(dateFrom);
        LocalDate parseDateTo = parseOptionalArgumentDateTo(dateTo);
        LogAnalyzer logAnalyzer = new LogAnalyzer(filePath, parseDateFrom, parseDateTo, outputFormat);
        logAnalyzer.readFile();
    }

    public static void main(String[] args) throws IOException {
        List<String> inputArguments = new ArrayList<>();
        inputArguments.addAll(Arrays.asList(args));

        new Runner().parseAndStartLogAnalyzer(inputArguments);
    }
}

