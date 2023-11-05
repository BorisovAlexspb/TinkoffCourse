package edu.project2;

import edu.project2.DFS.DeepFirstSearch;
import edu.project2.Kruskal.Edge;
import edu.project2.Kruskal.SortComparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings({"RegexpSinglelineJava", "ReturnCount"})
public class Maze {
    // Define class variables
    public static final int N = 1;
    public static final int S = 2;
    public static final int E = 4;
    public static final int W = 8;

    public static final int DEFAULT_WIDTH = 10;
    public static final int DEFAULT_HEIGHT = 5;
    public static final int NUMBER_TO_MAKE_NEW_COORDINATE = 20;

    protected Random random = null;
    protected DeepFirstSearch dfs;
    protected Scanner sc;
    protected int w = 0;
    protected int h = 0;
    protected int[][] grid = null;
    protected List<Edge> adjLists = new ArrayList<>();

    // Define class methods
    public static int dx(int direction) {
        switch (direction) {
            case Maze.E:
                return +1;
            case Maze.W:
                return -1;
            case Maze.N:
            case Maze.S:
                return 0;
            default:
        }
        // error condition, but should never reach here
        return -1;
    }

    public static int dy(int direction) {
        switch (direction) {
            case Maze.E:
            case Maze.W:
                return 0;
            case Maze.N:
                return -1;
            case Maze.S:
                return 1;
            default:
        }
        // error condition, but should never reach here
        return -1;
    }

    public static int opposite(int direction) {
        switch (direction) {
            case Maze.E:
                return Maze.W;
            case Maze.W:
                return Maze.E;
            case Maze.N:
                return Maze.S;
            case Maze.S:
                return Maze.N;
            default:
        }
        // error condition, but should never reach here
        return -1;
    }

    public Maze() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Maze(int w, int h) {
        initialize(w, h);
        random = new Random();
        sc = new Scanner(System.in);
        dfs = new DeepFirstSearch(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    private void initialize(int w, int h) {
        this.w = w;
        this.h = h;
        grid = new int[h][w];
        for (int j = 0; j < h; ++j) {
            for (int i = 0; i < w; ++i) {
                grid[j][i] = 0;
            }
        }
    }

    public void draw() {
        // draw the "top" line
        System.out.print(" ");
        for (int i = 0; i < (w * 2 - 1); ++i) {
            System.out.print("_");
        }
        System.out.println("");

        // draw each row
        for (int j = 0; j < h; ++j) {
            System.out.print("|");
            for (int i = 0; i < w; ++i) {
                // render "bottom" using the "S" switch
                System.out.print((grid[j][i] & Maze.S) != 0 ? " " : "_");

                // render "side" using "E" switch
                if ((grid[j][i] & Maze.E) != 0) {
                    System.out.print(((grid[j][i] | grid[j][i + 1]) & Maze.S) != 0 ? " " : "_");
                } else {
                    System.out.print("|");
                }
            }
            System.out.println("");
        }

        // output maze metadata
        outputMetadata();
    }

    protected void outputMetadata() {
        String meta = " " + w + " " + h;
        System.out.println(meta);
    }

    public void findTheWay() {
        System.out.println("Введите значения для марштрута");
        System.out.print("Введите x1 , y1: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.println();
        System.out.print("Введите x2 , y2: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println();

        adjLists.sort(new SortComparator());
        Stack<Edge> colorWay = dfs.dfs(new Edge(x1, y1), new Edge(x2, y2), adjLists);
        colorTheWay(colorWay);
    }

    public void colorTheWay(Stack<Edge> vertexToColor) {
        final int NUMBER_TO_DRAW = 27;
        // Draw the "top row" of the maze
        System.out.print((char) NUMBER_TO_DRAW + "[H");
        System.out.print(" ");
        for (int i = 0; i < (w * 2) - 1; ++i) {
            System.out.print("_");
        }
        System.out.println("");

        // Step through the grid/maze, cell-by-cell
        for (int y = 0; y < grid.length; ++y) {
            System.out.print("|");
            for (int x = 0; x < grid[0].length; ++x) {
                // Start coloring, if unconnected
                for (int i = 0; i < vertexToColor.size(); i++) {
                    if (vertexToColor.get(i).getX() == x && vertexToColor.get(i).getY() == y) {
                        System.out.print((char) NUMBER_TO_DRAW + "[47m");
                    }
                }

                System.out.print(((grid[y][x] & Maze.S) != 0) ? " " : "_");
                if ((grid[y][x] & Maze.E) != 0) {
                    System.out.print((((grid[y][x] | grid[y][x + 1]) & Maze.S) != 0) ? " " : "_");
                } else {
                    System.out.print("|");
                }
                // Stop coloring, if unconnected
                for (int i = 0; i < vertexToColor.size(); i++) {
                    if (vertexToColor.get(i).getX() == x && vertexToColor.get(i).getY() == y) {
                        System.out.print((char) NUMBER_TO_DRAW + "[m");
                    }
                }
            }
            System.out.println("");
        }
    }

    public int[][] getGrid() {
        return grid;
    }
}
