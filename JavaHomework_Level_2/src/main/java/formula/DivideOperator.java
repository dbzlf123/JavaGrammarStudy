package formula;

public class DivideOperator implements AbstractOperation{
    @Override
    public double operate(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }
}
