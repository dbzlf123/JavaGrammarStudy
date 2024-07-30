package formula;

public class DivideOperator<T extends Number> extends Operator<T>{

    @Override
    public T operate(Class<T> type, T firstNumber, T secondNumber) throws IllegalArgumentException {
        if(secondNumber.doubleValue() == 0) {
            System.out.println("나눗셈 연산에서 두번째 인자를 0 으로 줄 수 없습니다.");
            throw new IllegalArgumentException("Wrong Number");
        }
        return FormulaHelper.doTypeChange(type,firstNumber.doubleValue() / secondNumber.doubleValue());

    }
}
