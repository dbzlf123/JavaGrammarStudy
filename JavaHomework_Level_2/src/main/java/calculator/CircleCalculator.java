package calculator;

import java.util.Queue;

public class CircleCalculator extends Calculator {

    public CircleCalculator(Queue<Double> resultQueue) {
        super(resultQueue);
    }

    @Override
    public double calculate() {
        return Math.PI * Math.pow(Double.parseDouble(getRadius()), 2);
    }
}
