package calculator;
public class ArithmeticCalculator extends Calculator{

    @Override
    public double calculate() {
        double result = 0;
        result = getAo().operate(Double.parseDouble(getFirstNumber()) , Double.parseDouble(getSecondNumber()));
        return result;
    }
}
