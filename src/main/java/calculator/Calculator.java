package calculator;

import exception.CalculatorException;
import formula.*;

import java.util.Queue;
import java.util.regex.Pattern;

public abstract class Calculator {

    private AbstractOperation ao; //나는 너를 포함한다...
    private final Queue<Double> resultQueue; //Final 설정 이유 : 한번 설정하면 다시 안바뀔테니까.
    private String firstNumber;
    private String secondNumber;
    private String radius;
    private static final String symbolRegularExpression = "[+\\-*/%]"; //바뀔일도 없고 내부에서만 쓸거라 static 및 final...
    private static final String numRegularExpression = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?$";

    public Calculator(Queue<Double> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public abstract double calculate();

    public void checkNum(String input) throws CalculatorException {
        if(!Pattern.matches(numRegularExpression, input)){
            throw new CalculatorException("잘못된 값");
        }
    }

    public void checkOperator(String operationInput) throws CalculatorException {
        if (!Pattern.matches(symbolRegularExpression, operationInput)) {
            throw new CalculatorException("연산자");
        }
        switch (operationInput) {
            case "*":
                ao = new MultiplyOperator();
                break;
            case "+":
                ao = new AddOperator();
                break;
            case "-":
                ao = new SubstractOperator();
                break;
            case "/":
                if (Integer.parseInt(secondNumber)  == 0) {
                    throw new RuntimeException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    // 굳이 타입으로 안하고 난 다른 말 쓰고싶어서
                }
                ao = new DivideOperator();
                break;
            case "%":
                ao = new ModOperator();
        }
    }

    public AbstractOperation getAo() {
        return ao;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }


    public void removeResult() {
        if(!resultQueue.isEmpty()){
            resultQueue.remove();
        }
    }

    public void addResult(double result){
        resultQueue.add(result);
    }

    public void inquiryResults(){
        resultQueue.forEach(System.out::println);
    }


}
