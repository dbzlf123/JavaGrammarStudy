package calculator;

import formula.FormulaHelper;

import java.util.Queue;

public class CircleCalculator extends Calculator{

    public CircleCalculator(Queue<Double> resultQueue) {
        super(resultQueue);
    }

    private double radius;

    public double getRadius() {
        return radius;
    }
    public void setRadius(String radius) {
        this.radius = FormulaHelper.doTypeChange(Double.class, radius);
    }

    public double calculate() {
        return Math.PI * Math.pow((getRadius()), 2);
    }

}
