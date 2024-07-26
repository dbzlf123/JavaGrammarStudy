package formula;

public class MultiplyOperator<T extends  Number> extends Operator<T>{

    @Override
    public T operate(Class<T> type, T firstNumber, T secondNumber) {
        return FormulaHelper.doTypeChange(type,firstNumber.doubleValue() * secondNumber.doubleValue());

    }
}
