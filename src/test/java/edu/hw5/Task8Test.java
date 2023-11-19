package edu.hw5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import java.util.stream.Stream;
import static edu.hw5.Task8.isEveryOddNumberIsOne;
import static edu.hw5.Task8.isLengthOdd;
import static edu.hw5.Task8.isNotTwoOrThreeOnesInRow;
import static edu.hw5.Task8.startWithOneOrNullAndEvenOrOdd;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Task8Test {
    private static Stream<Arguments> firstRegexTest() {
        return Stream.of(
            Arguments.of("010", true),
            Arguments.of("0", true),
            Arguments.of("11", false),
            Arguments.of("222", false)
        );
    }

    private static Stream<Arguments> secondRegexTest() {
        return Stream.of(
            Arguments.of("10", true),
            Arguments.of("0", true),
            Arguments.of("1011", true),
            Arguments.of("01101", true),
            Arguments.of("100", false),
            Arguments.of("01", false)
        );
    }

    private static Stream<Arguments> fourthRegexTest() {
        return Stream.of(
            Arguments.of("1111", true),
            Arguments.of("000", true),
            Arguments.of("1000111", true),
            Arguments.of("", true),
            Arguments.of("11", false),
            Arguments.of("111", false)
        );
    }

    private static Stream<Arguments> fifthRegexTest() {
        return Stream.of(
            Arguments.of("10101", true),
            Arguments.of("1", true),
            Arguments.of("0", false),
            Arguments.of("1001", false),
            Arguments.of("1010", true),
            Arguments.of("1111", true),
            Arguments.of("0001", false)
        );
    }

    @ParameterizedTest
    @MethodSource("firstRegexTest")
    @DisplayName("Test of first regex")
    void isLengthOddTest(String zerosAndOnes, boolean ans) {
        Assertions.assertThat(isLengthOdd(zerosAndOnes)).isEqualTo(ans);
    }

    @ParameterizedTest
    @MethodSource("secondRegexTest")
    @DisplayName("Test of first regex")
    void startWithOneOrNullAndEvenOrOddTest(String zerosAndOnes, boolean ans) {
        Assertions.assertThat(startWithOneOrNullAndEvenOrOdd(zerosAndOnes)).isEqualTo(ans);
    }

    @ParameterizedTest
    @MethodSource("fourthRegexTest")
    @DisplayName("Test of first regex")
    void isNotTwoOrThreeOnesInRowTest(String zerosAndOnes, boolean ans) {
        Assertions.assertThat(isNotTwoOrThreeOnesInRow(zerosAndOnes)).isEqualTo(ans);
    }

    @ParameterizedTest
    @MethodSource("fifthRegexTest")
    @DisplayName("Test of first regex")
    void isEveryOddNumberIsOneTest(String zerosAndOnes, boolean ans) {
        Assertions.assertThat(isEveryOddNumberIsOne(zerosAndOnes)).isEqualTo(ans);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Every regex with null source test")
    public void regexes_ShouldThrowException(String nullString) {
        assertAll(
            () -> assertThatThrownBy(() -> isLengthOdd(nullString))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> startWithOneOrNullAndEvenOrOdd(nullString))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> isNotTwoOrThreeOnesInRow(nullString))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> isEveryOddNumberIsOne(nullString))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
