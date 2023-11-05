package edu.project2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class MazeGeneratorTest {

    private static Stream<Arguments> provideSizeOfMaze() {
        return Stream.of(
            Arguments.of(5, 5, 5),
            Arguments.of(10, 10, 10),
            Arguments.of(10, 5, 5)
        );
    }

    @ParameterizedTest
    @DisplayName("Test Maze Generator")
    @MethodSource("provideSizeOfMaze")
    void checkCorrectSize(int x, int y, int length) {
        Maze maze = new Maze(x, y);
        int[][] res = maze.getGrid();
        Assertions.assertThat(res.length).isEqualTo(length);
    }
}
