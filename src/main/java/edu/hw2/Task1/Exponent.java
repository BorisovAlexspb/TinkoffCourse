package edu.hw2.Task1;

public record Exponent(double number1, double number2) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(number1, number2);
    }

    public Exponent(Expr expr1, double degree) {
        this(expr1.evaluate(), degree);
    }
}
