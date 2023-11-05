package edu.hw3.Task6;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockQueue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockQueueTest {

    @Test
    void checkAddMethod() {
        StockQueue stockq = new StockQueue();
        Throwable exception = assertThrows(NullPointerException.class, () -> stockq.add(null));
        assertEquals("Null pointer", exception.getMessage());

        stockq.add(new Stock(5.0));
        var res = stockq.mostValuableStock();
        Assertions.assertThat(res).isInstanceOf(Stock.class);
    }

    @Test
    void checkRemoveMethod() {
        StockQueue stockq = new StockQueue();
        Throwable exception = assertThrows(NullPointerException.class, () -> stockq.remove(null));
        assertEquals("Null pointer", exception.getMessage());

        stockq.add(new Stock(5.0));
        stockq.remove(new Stock(5.0));
        var res = stockq.mostValuableStock();
        Assertions.assertThat(res).isNull();
    }
}
