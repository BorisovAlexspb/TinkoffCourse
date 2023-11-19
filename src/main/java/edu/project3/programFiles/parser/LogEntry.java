package edu.project3.programFiles.parser;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * Class provided by course.
 * Added getMonthDay() method to access date in appropriate format and
 * not to convert it to string every time I need it.
 */

public class LogEntry {
    private String ipAddress;
    private LocalDateTime accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;

    public LogEntry(String ip, LocalDateTime time, String req, int status, int bytes) {
        ipAddress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getAccessTime() {
        return accessTime;
    }

    public String getMonthDay() {
        SimpleDateFormat formatDay = new SimpleDateFormat("dd");
        SimpleDateFormat formatMonth = new SimpleDateFormat("MMM");

        String currentDay = formatDay.format(accessTime);
        String currentMonth = formatMonth.format(accessTime);

        return currentMonth + " " + currentDay;
    }

    public String getRequest() {
        return request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getBytesReturned() {
        return bytesReturned;
    }

    public String toString() {
        return ipAddress + " " + accessTime + " " + request
            + " " + statusCode + " " + bytesReturned;
    }
}

