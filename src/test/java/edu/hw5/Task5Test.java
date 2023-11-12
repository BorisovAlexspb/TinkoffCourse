package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task5.isNumberValid;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task5Test {
    private static Stream<Arguments> carNumbersForTest() {
        return Stream.of(
            Arguments.of("А123ВЕ777", true),
            Arguments.of("О777ОО177", true),
            Arguments.of("123АВЕ777", false),
            Arguments.of("А123ВЕ77", false),
            Arguments.of("А123ВЕ7777", false)
        );
    }

    @ParameterizedTest
    @MethodSource("carNumbersForTest")
    public void isNumberValid_shouldReturnTrue_whenNumberIsValid(String carNumber, boolean isValid) {
        assertThat(isNumberValid(carNumber)).isEqualTo(isValid);
    }

    @DisplayName("Null input test")
    public void isisNumberValid_shouldThrowException_whenStringIsNull() {
        assertThatThrownBy(() -> isNumberValid(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
