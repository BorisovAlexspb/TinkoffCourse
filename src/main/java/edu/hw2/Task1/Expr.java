package edu.hw2.Task1;

sealed interface Expr permits Negate, Constant, Multiplication, Addition, Exponent {

    double evaluate();
}
