package edu.project2;

import edu.project2.Kruskal.Kruskal;

@SuppressWarnings({"HideUtilityClassConstructor", "UncommentedMain"})
public class Driver {
    public static void main(String[] args) {
        // configure the width and height
        int w = Maze.DEFAULT_WIDTH;
        int h = Maze.DEFAULT_HEIGHT;
        // render the maze
        new Kruskal(w, h).draw();
    }
}
