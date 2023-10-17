package edu.hw2.Task1;

public record Multiplication(double number1, double number2) implements Expr {
    @Override
    public double evaluate() {
        return number1 * number2;
    }

    public Multiplication(Expr expr1, Expr expr2) {
        this(expr1.evaluate(), expr2.evaluate());
    }
}
