package edu.hw1;

public class Task1 {
    static final int MAXASCII = 48;
    static final int MINASCII = 58;
    static final int MINUTEMAX = 60;

    public int problem(String str) {
        int time = 0;
        String timeStr = "";
        if (!str.contains(":")) {
            return -1;
        }
        for (char c : str.toCharArray()) {
            if ((int) c < MAXASCII || (int) c > MINASCII) {
                return -1;
            }
            if (c == ':') {
                time = Integer.parseInt(timeStr);
                time *= MINUTEMAX;
                timeStr = "";
                continue;
            }
            timeStr += c;
        }
        if (Integer.parseInt(timeStr) < MINUTEMAX) {
            time += Integer.parseInt(timeStr);
        } else {
            return -1;
        }
        return time;
    }
}
