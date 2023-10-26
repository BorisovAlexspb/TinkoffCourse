package edu.hw2;

import edu.hw2.Task1.Addition;
import edu.hw2.Task1.Constant;
import edu.hw2.Task1.Exponent;
import edu.hw2.Task1.Multiplication;
import edu.hw2.Task1.Negate;
import edu.hw2.Task1.Task1;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class Task1Test {
    @ParameterizedTest
    @MethodSource("valueToCalculate")
    void CalculateTest(double constant1, double constant2, double degree) {
        Task1 task1 = new Task1();
        double ans = task1.calculate(constant1, constant2, degree);
        Assertions.assertThat(ans).isNotEqualTo(Double.MAX_VALUE);
    }

    static Stream<Arguments> valueToCalculate() {
        return Stream.of(
            Arguments.arguments(1, 1, 2),
            Arguments.arguments(2, 2, 2),
            Arguments.arguments(-1, 0, 3)
        );
    }
}
