package formula;

public class SubstractOperator implements AbstractOperation{
    @Override
    public double operate(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
}
