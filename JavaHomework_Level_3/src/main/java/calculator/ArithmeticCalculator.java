package calculator;
import formula.*;

import java.util.Arrays;
import java.util.Queue;

//Number 형을 받겠다.
public class ArithmeticCalculator<T extends Number> extends Calculator{

    public ArithmeticCalculator(Queue<Double> resultQueue) {
        super(resultQueue);
    }

    private T firstNumber;
    private T secondNumber;
    private String symbol;

    //final 붙이면 생성시 초기화 해야하는데 나중에 런타임때 타입바꾸고싶기때문에..
    //현재 상태에서는 제네릭 클래스이기때문에 생성자에 값을 넣어주는게 더 자연스럽겠지?
    private Class<T> type;

    //final 용 생서자 지만 안써도..
//    public ArithmeticCalculator(Class<T> type) {
//        this.type = type;
//    }


    @Override
    public void inquiryResults() {
        getResultQueue().
                stream().
                map(val -> FormulaHelper.doTypeChange(type, val)).
                forEach(System.out::println);
    }

    public void setFirstNumber(String firstNumber){
        this.firstNumber = FormulaHelper.doTypeChange(type, firstNumber);
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = FormulaHelper.doTypeChange(type, secondNumber);
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public void setType(Class<T> type) {
        this.type = type;
    }

    public static OperatorType checkOperator(String code)  {
        OperatorType temp = Arrays.stream(OperatorType.values())
                .filter(val -> code.equals(val.getOperator()))
                .findFirst()
                .orElse(null);

        if(temp == null){ //사실 이미 타입검증을 해서 한번 걸러내기때문에 필요없음
            throw new IllegalArgumentException("잘못된 입력");
        }else return temp;
    }


    //나중에 런타임 타입 변경용..
    //어노테이션으로 캐스팅 타입이 불확실해서 나오는 경고문 날려버림. 왜? 저 조건이면 다른거 들어올일이 없기떄문.
    //하지만 보통은 캐스팅 안전한지 확인하고 해야함
//    @SuppressWarnings("unchecked")
//    public void changeType(String str){
//        switch (str){
//            case "int" :
//                this.type = (Class<T>) Integer.class;
//                break;
//            case "long" :
//                this.type = (Class<T>) Long.class;
//                break;
//            case "float" :
//                this.type = (Class<T>) Float.class;
//                break;
//            case "double" :
//                this.type = (Class<T>) Double.class;
//                break;
//        }
//    }

    private AbstractOperation<T> setOperator() {
        OperatorType operatorType = checkOperator(symbol);
        return switch (operatorType) {
            case MULTIPLY ->
                    new MultiplyOperator<>(); //제네릭 타입 생성할 때 사용함 <>
            case ADD ->
                    new AddOperator<>();
            case SUBTRACT ->
                    new SubstractOperator<>();
            case DIVIDE ->
                    new DivideOperator<>();
            case MOD ->
                    new ModOperator<>();
        };//인텔리제이가 추천해준 향상된 스위치문.. 눌렀더니 알아서 다 바꿔줬다.
        //https://dev-kani.tistory.com/21
    }

    void compareResult(String result){
        getResultQueue().
                stream().
                filter(val-> FormulaHelper.doTypeChange(type, result).doubleValue() > val).
                map(val -> FormulaHelper.doTypeChange(type, val)).
                forEach(System.out::println);
    }

    public T calculate() {
        return setOperator().operate(type, firstNumber, secondNumber);
    }
}
