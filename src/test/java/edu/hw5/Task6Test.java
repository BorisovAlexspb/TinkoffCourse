package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import java.util.stream.Stream;
import static edu.hw5.Task6.isSubstring;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task6Test {
    private static Stream<Arguments> textAndItsSubstring() {
        return Stream.of(
            Arguments.of("TOKYO", "TORONTOTOKYO", true),
            Arguments.of("av", "java", true),
            Arguments.of("do you love me", "kiki", false),
            Arguments.of("pyatigorsk", "pyatig", false)
        );
    }

    @ParameterizedTest
    @MethodSource("textAndItsSubstring")
    @DisplayName("Substring validation test")
    public void isSubstring_shouldReturnTrue(
        String substring,
        String text,
        boolean isCorrect
    ) {
        assertThat(isSubstring(substring, text)).isEqualTo(isCorrect);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null text test")
    public void isSubstring_shouldThrowException(String text) {
        assertThatThrownBy(() -> isSubstring(text, "substring")).isInstanceOf(IllegalArgumentException.class);
    }
}
