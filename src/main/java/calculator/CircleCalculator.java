package calculator;

import formula.FormulaHelper;

public class CircleCalculator extends Calculator{

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
