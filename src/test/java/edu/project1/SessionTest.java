package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    //Scanner sc = new Scanner(System.in);
   //Session session = new Session(5, new char[]{'c', 'a', 't'},new char[]{'*', '*', '*'});
    @Test
    void CheckRightInput() {
        Session session = new Session(5, new char[]{'c', 'a', 't'},new char[]{'*', '*', '*'});
        String gamerInput = "c";
        boolean check = session.makeMove(gamerInput);
        Assertions.assertThat(check).isEqualTo(true);
    }
    @Test
    @DisplayName("игрок отгадал слово")
    void CheckGamerGuessTheWord() {
        Session session = new Session(5, new char[]{'c'},new char[]{'*'});
        String gamerInput = "c";
        boolean check = session.makeMove(gamerInput);
        Assertions.assertThat(check).isEqualTo(false);
    }
    @Test
    @DisplayName("разрешен один неккоретктный ввод, игрок сделал 2")
    void CheckMaxFailedAttempt() {
        Session session = new Session(1, new char[]{'c'},new char[]{'*'});
        String gamerInput = "d";
        boolean check = session.makeMove(gamerInput);
        gamerInput = "е";
        check = session.makeMove(gamerInput);
        Assertions.assertThat(check).isEqualTo(false);
    }
}
