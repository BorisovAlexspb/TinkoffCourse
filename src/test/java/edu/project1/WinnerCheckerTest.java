package edu.project1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnerCheckerTest {
    @Test
    @DisplayName("Проверка наличия символа (*)")
    void isPlayerWincheck1() {
        WinnerChecker winch = new WinnerChecker();
        boolean res = winch.isPlayerWin(new char[] {'c', 't', '*'});
        Assertions.assertThat(res).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверка отсутствия символа (*)")
    void isPlayerWincheck2() {
        WinnerChecker winch = new WinnerChecker();
        boolean res = winch.isPlayerWin(new char[] {'c', 't', 'а'});
        Assertions.assertThat(res).isEqualTo(true);
    }
}
