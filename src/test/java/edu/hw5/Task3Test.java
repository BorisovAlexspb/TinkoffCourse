package edu.hw5;

import edu.hw5.Task3.Parser1;
import edu.hw5.Task3.Parser2;
import edu.hw5.Task3.Parser3;
import edu.hw5.Task3.Parser4;
import edu.hw5.Task3.Parser5;
import edu.hw5.Task3.Parser6;
import edu.hw5.Task3.ParserHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

class Task3Test {
    private ParserHandler parser1;
    private ParserHandler parser2;
    private ParserHandler parser3;
    private ParserHandler parser4;
    private ParserHandler parser5;
    private ParserHandler parser6;

    @BeforeEach
    void setup() {
        parser1 = new Parser1();
        parser2 = new Parser2();
        parser3 = new Parser3();
        parser4 = new Parser4();
        parser5 = new Parser5();
        parser6 = new Parser6();

        parser1.setNextParser(parser2);
        parser2.setNextParser(parser3);
        parser3.setNextParser(parser4);
        parser4.setNextParser(parser5);
        parser5.setNextParser(parser6);
    }

    private static Stream<Arguments> differentFormatsOfDate() {
        return Stream.of(
            Arguments.of("2020-10-10", LocalDate.of(2020, 10, 10)),
            Arguments.of("2020-12-2", LocalDate.of(2020, 12, 2)),
            Arguments.of("1/3/1976", LocalDate.of(1976, 3, 1)),
            Arguments.of("1/3/20", LocalDate.of(2020, 3, 1)),
            Arguments.of("tomorrow", LocalDate.now().plusDays(1)),
            Arguments.of("today", LocalDate.now()),
            Arguments.of("yesterday", LocalDate.now().minusDays(1)),
            Arguments.of("1 days ago", LocalDate.now().minusDays(1)),
            Arguments.of("2234 days ago", LocalDate.now().minusDays(2234))
        );
    }

    @ParameterizedTest
    @MethodSource("differentFormatsOfDate")
    public void parseDateTest(String inputString, LocalDate expectedAnswer) {
        Optional<LocalDate> ans = parser1.parseDate(inputString);
        Assertions.assertThat(ans.get()).isEqualTo(expectedAnswer);
    }
}
