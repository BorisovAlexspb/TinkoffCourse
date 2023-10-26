package edu.hw2.Task1;

public record Negate(double number) implements Expr {
    @Override
    public double evaluate() {
        return -number;
    }

    public Negate(Expr expr) {
        this(expr.evaluate());
    }
}
