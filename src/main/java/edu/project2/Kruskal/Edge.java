package edu.project2.Kruskal;

import java.util.ArrayList;
import java.util.List;

public class Edge {
    private int x;
    private int y;
    private int direction;
    List<Edge> adjLists = new ArrayList<>();

    public Edge(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void addEdge(Edge coordinate) {
        adjLists.add(coordinate);
    }

    public List<Edge> getAdjLists() {
        return adjLists;
    }
}
