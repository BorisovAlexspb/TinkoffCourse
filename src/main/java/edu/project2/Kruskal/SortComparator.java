package edu.project2.Kruskal;

import edu.project2.Maze;
import java.util.Comparator;

public class SortComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        if ((o1.getX() * Maze.NUMBER_TO_MAKE_NEW_COORDINATE + o1.getY())
            > (o2.getX() * Maze.NUMBER_TO_MAKE_NEW_COORDINATE + o2.getY())) {
            return 1;
        } else {
            return -1;
        }
    }
}
