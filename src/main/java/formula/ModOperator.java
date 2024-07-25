package formula;

public class ModOperator implements AbstractOperation{

    @Override
    public double operate(double firstNumber, double secondNumber) {
        return firstNumber % secondNumber;
    }
}
