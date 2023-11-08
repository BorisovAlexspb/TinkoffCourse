package edu.project2;

import edu.project2.Kruskal.Kruskal;
import java.util.Scanner;

@SuppressWarnings({"HideUtilityClassConstructor", "UncommentedMain", "RegexpSinglelineJava"})
public class Driver {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // configure the width and height
        int w = Maze.DEFAULT_WIDTH;
        int h = Maze.DEFAULT_HEIGHT;
        Kruskal kruskal = new Kruskal(w, h);
        // render the maze
        kruskal.draw();

        // find the way
        System.out.println("Введите значения для марштрута");
        System.out.print("Введите x1 , y1: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.println();
        System.out.print("Введите x2 , y2: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println();

        kruskal.findTheWay(x1, y1, x2, y2);
    }
}
