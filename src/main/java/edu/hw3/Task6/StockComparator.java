package edu.hw3.Task6;

import java.util.Comparator;

class StockComparator implements Comparator<Stock> {
    public int compare(Stock st1, Stock st2) {
        if (st1.price() < st2.price()) {
            return 1;
        } else if (st1.price() > st2.price()) {
            return -1;
        } else {
            return 0;
        }
    }
}
