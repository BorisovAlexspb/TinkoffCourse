package edu.project2.DFS;

import edu.project2.Kruskal.Edge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"CyclomaticComplexity", "NestedIfDepth"})
public class DeepFirstSearch extends Search {
    List<Edge> path;

    public DeepFirstSearch(int width, int height, List<Edge> adjLists) {
        super(width, height, adjLists);
        path = new ArrayList<Edge>();
    }

    // Создание графа
    public List<Edge> getShortWay(Edge start, Edge end) {
        if (dfs(start, end)) {
            return path;
        } else {
            return Collections.emptyList();
        }
    }

    // Algoritm
    public boolean dfs(Edge current, Edge end) {
        path.add(current);
        int x = current.getX();
        int y = current.getY();
        isVisited[y][x] = true;
        if ((x == end.getX()) && (y == end.getY())) {
            return true;
        }
        List<Edge> neighbours = getNeighbours(x, y);
        for (Edge coordinate : neighbours) {
            if (!isVisited[coordinate.getY()][coordinate.getX()]) {
                if (dfs(coordinate, end)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}


