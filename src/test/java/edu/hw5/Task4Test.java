package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task4.isPasswordValid;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    private static Stream<Arguments> correctPasswords() {
        return Stream.of(
            Arguments.of("~aboba"),
            Arguments.of("aboba!"),
            Arguments.of("@@aboba"),
            Arguments.of("###aboba"),
            Arguments.of("zxc$"),
            Arguments.of("qw%e"),
            Arguments.of("kan&eki"),
            Arguments.of("pos1only^"),
            Arguments.of("mmm*"),
            Arguments.of("gho|ul")
        );
    }

    private static Stream<Arguments> wrongPasswords() {
        return Stream.of(
            Arguments.of("aboba"),
            Arguments.of(""),
            Arguments.of("12adsa__")
        );
    }

    @ParameterizedTest
    @MethodSource("correctPasswords")
    @DisplayName("Passwords with required signs test")
    public void isPasswordValid_shouldReturnTrue(String signs) {
        assertTrue(isPasswordValid(signs));
    }

    @ParameterizedTest
    @MethodSource("wrongPasswords")
    @DisplayName("Passwords without required signs test")
    public void isPasswordValid_shouldReturnFalse(String password) {
        assertFalse(isPasswordValid(password));
    }

    @DisplayName("Null input test")
    public void isPasswordValid_shouldThrowException() {
        assertThatThrownBy(() -> isPasswordValid(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
