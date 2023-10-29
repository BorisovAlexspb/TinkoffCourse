package edu.hw3.Task6;

import java.util.PriorityQueue;

public class StockQueue implements StockMarket {
    PriorityQueue<Stock> stockqueue = new PriorityQueue<>(new StockComparator());
    final String exceptionMessage = "Null pointer";

    @Override
    public void add(Stock stock) {
        if (stock == null) {
            throw new NullPointerException(exceptionMessage);
        }
        stockqueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        if (stock == null) {
            throw new NullPointerException(exceptionMessage);
        }
        stockqueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockqueue.peek();
    }

    @Override
    public String toString() {
        return "mostValuableStock is " + stockqueue.peek();
    }
}
