package edu.hw3;

import edu.hw3.Task5.Task5;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task5Test {
    @BeforeEach
    void setup() {
        task5 = new Task5();
    }

    private Task5 task5;

    @Test
    void parseContactsCheckNullFullname() {
        var res = task5.parseContacts(null, "ASC");
        Assertions.assertThat(res).isEmpty();
    }

    @Test
    void parseContactsCheckEmptyFullname() {
        var res = task5.parseContacts(new String[] {}, "ASC");
        Assertions.assertThat(res).isEmpty();
    }

    @Test
    void parseContactsCheckNotEmptyFullname() {
        var res =
            task5.parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC");
        Assertions.assertThat(res).isNotEmpty();
    }
}
