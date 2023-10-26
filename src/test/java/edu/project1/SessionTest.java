package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionTest {

    @Test
    void CheckRightInput() {
        final Logger LOGGER = LogManager.getLogger();
        Session session = new Session(new char[] {'c', 'a', 't'}, new Scanner(System.in), LOGGER);
        String gamerInput = "c";
        boolean check = session.makeMove(gamerInput);
        Assertions.assertThat(check).isEqualTo(true);
    }

    @Test
    @DisplayName("игрок отгадал слово")
    void CheckGamerGuessTheWord() {
        final Logger LOGGER = LogManager.getLogger();
        Session session = new Session(new char[] {'c'}, new Scanner(System.in), LOGGER);
        String gamerInput = "c";
        boolean check = session.makeMove(gamerInput);
        Assertions.assertThat(check).isEqualTo(false);
    }

    @Test
    @DisplayName("разрешен один неккоретктный ввод, игрок сделал 2")
    void CheckMaxFailedAttempt() {
        final Logger LOGGER = LogManager.getLogger();
        Session session = new Session(new char[] {'c'}, new Scanner(System.in), LOGGER);
        String gamerInput = "d";
        boolean check = session.makeMove(gamerInput);
        gamerInput = "е";
        check = session.makeMove(gamerInput);
        Assertions.assertThat(check).isEqualTo(false);
    }
}
