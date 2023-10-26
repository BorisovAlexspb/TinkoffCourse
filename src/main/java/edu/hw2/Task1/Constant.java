package edu.hw2.Task1;

public record Constant(double number) implements Expr {
    @Override
    public double evaluate() {
        final double constant = number;
        return constant;
    }

    public Constant(Expr expr) {
        this(expr.evaluate());
    }
}
