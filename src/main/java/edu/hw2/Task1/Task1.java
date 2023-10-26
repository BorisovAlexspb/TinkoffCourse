package edu.hw2.Task1;

public class Task1 {
    public double calculate(double constant1, double constant2, double degree) {
        var two = new Constant(constant1);

        var four = new Constant(constant2);

        var negOne = new Negate(new Constant(constant1));

        var sumTwoFour = new Addition(two, four);

        var multi = new Multiplication(sumTwoFour, negOne);

        var exp = new Exponent(multi, degree);

        var res = new Addition(exp, new Constant(constant2));

        try {
            double result = res.evaluate();
        } catch (Exception e) {
            return Double.MAX_VALUE;
        }
        return res.evaluate();
        //System.out.println("res = " + res.evaluate());
    }
}
