package edu.project2.Kruskal;

import edu.project2.DFS.DeepFirstSearch;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("RegexpSinglelineJava")
public class Kruskal extends Maze {
    // Define instance variables
    private List<List<Tree>> sets;
    private Stack<Edge> edges;
    DeepFirstSearch dfs;

    //
    // Standard Constructors
    //
    public Kruskal() {
        //super();
        dfs = new DeepFirstSearch(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        initialize();
    }

    public Kruskal(int w, int h) {
        super(w, h);
        dfs = new DeepFirstSearch(w, h);
        initialize();
    }

    private void initialize() {
        // Initialize the sets to the same dimension as the maze.
        // We use Tree objects to represent the sets to be joined.
        sets = new ArrayList<List<Tree>>();
        for (int y = 0; y < h; ++y) {
            List<Tree> tmp = new ArrayList<Tree>();
            for (int x = 0; x < w; ++x) {
                tmp.add(new Tree());
            }
            sets.add(tmp);
        }

        // Build the collection of edges and randomize.
        // Edges are "north" and "west" sides of cell,
        // if index is greater than 0.
        edges = new Stack<Edge>();
        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                if (y > 0) {
                    edges.add(new Edge(x, y, Maze.N));
                }
                if (x > 0) {
                    edges.add(new Edge(x, y, Maze.W));
                }
            }
        }

        shuffle(edges);
        carvePassages();
    }

    public void draw() {
        // Clear the screen
        final int NUMBER_FOR_DRAW = 27;
        System.out.print((char) NUMBER_FOR_DRAW + "[2J");

        // Move to the upper left and defer to superclass.
        System.out.print((char) NUMBER_FOR_DRAW + "[H");
        super.draw();
        findTheWay();
    }

    private void carvePassages() {
        while (!edges.isEmpty()) {
            // Select the next edge, and decide which direction we are going in.
            Edge tmp = edges.pop();
            int x = tmp.getX();
            int y = tmp.getY();
            int direction = tmp.getDirection();
            int dx = x + Maze.dx(direction);
            int dy = y + Maze.dy(direction);

            // Pluck out the corresponding sets
            Tree set1 = (sets.get(y)).get(x);
            Tree set2 = (sets.get(dy)).get(dx);

            if (!set1.connected(set2)) {
                int coordinate1 = x * NUMBER_TO_MAKE_NEW_COORDINATE + y;
                int coordinate2 = dx * NUMBER_TO_MAKE_NEW_COORDINATE + dy;
                adjLists.add(new Edge(coordinate1, coordinate2));

                set1.connect(set2);
                grid[y][x] |= direction;
                grid[dy][dx] |= Maze.opposite(direction);
            }
        }
    }

    private void shuffle(List<Edge> args) {
        for (int i = 0; i < args.size(); ++i) {
            int pos = random.nextInt(args.size());
            Edge tmp1 = args.get(i);
            Edge tmp2 = args.get(pos);
            args.set(i, tmp2);
            args.set(pos, tmp1);
        }
    }

    public List<Edge> getAdjLists() {
        return adjLists;
    }
}
