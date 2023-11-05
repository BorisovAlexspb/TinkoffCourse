package edu.hw3.Task6;

import java.util.Comparator;

class StockComparator implements Comparator<Stock> {
    public int compare(Stock st1, Stock st2) {
        return Double.compare(st1.price(), st2.price());
    }
}
