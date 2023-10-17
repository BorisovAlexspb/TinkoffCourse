package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
class Task2Test {

    @Test
    void rectangleArea1() {
        Rectangle rect = new Rectangle(3,4);

        Assertions.assertThat(rect.getSize()).isEqualTo(12);
    }
    @Test
    void squareArea1() {
        Square sq = new Square(4);

        Assertions.assertThat(sq.getSize()).isEqualTo(16);
    }
    @Test
    void rectangleArea2() {
        Rectangle rect = new Rectangle(0,4);

        Assertions.assertThat(rect.getSize()).isEqualTo(0);
    }
    @Test
    void squareArea2() {
        Square sq = new Square(10);

        Assertions.assertThat(sq.getSize()).isEqualTo(100);
    }
}
