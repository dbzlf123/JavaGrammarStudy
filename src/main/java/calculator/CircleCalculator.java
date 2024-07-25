package calculator;

import exception.CalculatorException;
import formula.AbstractOperation;

import java.util.Queue;

public class CircleCalculator extends Calculator {
    @Override
    public double calculate() {
        return Math.PI * Math.pow(Double.parseDouble(getRadius()), 2);
    }
}
