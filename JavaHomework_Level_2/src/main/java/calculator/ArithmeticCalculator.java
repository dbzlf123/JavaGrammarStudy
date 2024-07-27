package calculator;

import java.util.Queue;

public class ArithmeticCalculator extends Calculator{

    public ArithmeticCalculator(Queue<Double> resultQueue) {
        super(resultQueue);
    }

    @Override
    public double calculate() {
        return getAo().operate(Double.parseDouble(getFirstNumber()) , Double.parseDouble(getSecondNumber()));
    }
}
