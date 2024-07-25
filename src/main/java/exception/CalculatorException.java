package exception;

public class CalculatorException extends Exception{

    public CalculatorException(String type){
        System.out.println("잘못된 " + type + " 입니다. 다시 입력하세요.");
    }
}
