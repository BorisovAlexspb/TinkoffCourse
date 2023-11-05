package edu.project2.DFS;

import edu.project2.Kruskal.Edge;
import edu.project2.Maze;
import java.util.List;
import java.util.Stack;

@SuppressWarnings({"CyclomaticComplexity", "NestedIfDepth"})
public class DeepFirstSearch {
    private int width;
    private int height;
    Stack<Edge> stack;
    boolean[][] isVisited;

    // Создание графа
    public DeepFirstSearch(int width, int height) {
        this.width = width;
        this.height = height;
        this.stack = new Stack<Edge>();
        isVisited = new boolean[height][width];
    }

    // Algoritm
    public Stack<Edge> dfs(Edge start, Edge end, List<Edge> adjLists) {
        stack.push(start);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                isVisited[i][j] = false;
            }
        }
        while (!stack.isEmpty()) {
            Edge current = stack.peek();
            int x = current.getX();
            int y = current.getY();
            if (!isVisited[y][x]) {
                isVisited[y][x] = true;
                if ((x == end.getX()) && (y == end.getY())) {
                    break;
                }
                for (Direction dir : Direction.values()) {
                    int xChange = x + dir.getDx();
                    int yChange = y + dir.getDy();
                    if ((xChange >= 0) && (xChange < Maze.DEFAULT_WIDTH) && (yChange >= 0)
                        && (yChange < Maze.DEFAULT_HEIGHT)) {
                        for (int i = 0; i < adjLists.size(); i++) {
                            if (adjLists.get(i).getX() == (x * Maze.NUMBER_TO_MAKE_NEW_COORDINATE + y)
                                &&
                                adjLists.get(i).getY() == (xChange * Maze.NUMBER_TO_MAKE_NEW_COORDINATE + yChange)) {
                                if (!isVisited[yChange][xChange]) {
                                    stack.push(new Edge(xChange, yChange));
                                }
                            } else if (adjLists.get(i).getY() == (x * Maze.NUMBER_TO_MAKE_NEW_COORDINATE + y)
                                &&
                                adjLists.get(i).getX() == (xChange * Maze.NUMBER_TO_MAKE_NEW_COORDINATE + yChange)) {
                                if (!isVisited[yChange][xChange]) {
                                    stack.push(new Edge(xChange, yChange));
                                }
                            }
                        }
                    }
                }
            } else {
                stack.pop();
            }
        }
        return stack;
    }
}


