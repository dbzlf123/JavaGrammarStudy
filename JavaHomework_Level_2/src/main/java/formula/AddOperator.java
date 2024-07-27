package formula;

public class AddOperator implements AbstractOperation{


    @Override
    public double operate(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
