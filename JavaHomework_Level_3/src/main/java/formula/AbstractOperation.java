package formula;

public interface  AbstractOperation<T extends Number> {

    T operate(Class<T> input, T firstNumber, T secondNumber);
}
