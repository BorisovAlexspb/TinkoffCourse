package edu.hw2;

import edu.hw2.Task3.Connection.FaultyConnection;
import edu.hw2.Task3.Connection.StableConnection;
import edu.hw2.Task3.Manager.DefaultConnectionManager;
import edu.hw2.Task3.Manager.FaultyConnectionManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task3Test {
    @Test
    @DisplayName("Проверка, что всегда будет Stable Connection")
    void test1() {
        //given
        var manager = new DefaultConnectionManager(0.0);

        //when
        var connection = manager.getConnection();

        //then
        Assertions.assertThat(connection).isInstanceOf(StableConnection.class);
    }

    @Test
    @DisplayName("Проверка, что всегда будет Faulty Connection")
    void test2() {
        //given
        var manager = new DefaultConnectionManager(1.0);

        //when
        var connection = manager.getConnection();

        //then
        Assertions.assertThat(connection).isInstanceOf(FaultyConnection.class);
    }

    @Test
    @DisplayName("Всегда проблемное соединение")
    void test3() {
        //given
        var manager = new FaultyConnectionManager();

        //when
        var connection = manager.getConnection();

        //then
        Assertions.assertThat(connection).isInstanceOf(FaultyConnection.class);
    }

}
