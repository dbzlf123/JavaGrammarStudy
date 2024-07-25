package formula;

public class MultiplyOperator implements AbstractOperation{
    @Override
    public double operate(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
