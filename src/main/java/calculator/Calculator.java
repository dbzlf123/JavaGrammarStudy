package calculator;

import exception.CalculatorException;
import formula.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

public abstract class Calculator {

    private AbstractOperation ao;
    private final Queue<Double> resultQueue = new LinkedList<>(); //Final 설정 이유 : 한번 설정하면 다시 안바뀔테니까.
    private String firstNumber;
    private String secondNumber;
    private String radius;
    private final String symbolRegularExpression = "[+\\-*/%]";
    private final String numRegularExpression = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?$";

    public abstract double calculate();

    public Calculator checkNum(String input) throws CalculatorException {
        if(!Pattern.matches(numRegularExpression, input)){
            throw new CalculatorException("잘못된 값");
        }
        return this;
    }

    public Calculator checkOperator(String operationInput) throws CalculatorException {
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
        return this;
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
