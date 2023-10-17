package edu.hw2.Task2;

public class Rectangle implements GetArea {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getSize() {
        return width * height;
    }
}
