package edu.project2;

import edu.project2.DFS.DeepFirstSearch;
import edu.project2.Kruskal.Edge;
import edu.project2.Kruskal.Kruskal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

public class MazeFindCorrectWayTest {
    private static Stream<Arguments> provideWayInMaze() {
        return Stream.of(
            Arguments.of(new Kruskal(10, 10), new Edge(0, 0), new Edge(3, 3)),
            Arguments.of(new Kruskal(5, 5), new Edge(0, 0), new Edge(3, 3)),
            Arguments.of(new Kruskal(10, 5), new Edge(0, 0), new Edge(3, 3))
        );
    }

    @ParameterizedTest
    @DisplayName("Test Maze Find Correct Way")
    @MethodSource("provideWayInMaze")
    void checkWayTest(Kruskal kruskal, Edge start, Edge end) {
        //kruskal.draw();

        List<Edge> adjList = kruskal.getAdjLists();
        var dfs = new DeepFirstSearch(kruskal.w, kruskal.h).dfs(start, end, adjList);

        Assertions.assertThat(dfs.get(0).getX()).isEqualTo(start.getX());
        Assertions.assertThat(dfs.get(0).getY()).isEqualTo(start.getY());

        Assertions.assertThat(dfs.get(dfs.size() - 1).getX()).isEqualTo(end.getX());
        Assertions.assertThat(dfs.get(dfs.size() - 1).getY()).isEqualTo(end.getY());
    }
}
