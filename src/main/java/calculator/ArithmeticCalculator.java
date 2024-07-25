package calculator;
public class ArithmeticCalculator extends Calculator{

    @Override
    public double calculate() {
        return getAo().operate(Double.parseDouble(getFirstNumber()) , Double.parseDouble(getSecondNumber()));
    }
}
