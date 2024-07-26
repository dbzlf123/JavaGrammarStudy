package formula;


//계산식 최상위 부모, 인터페이스가 가질수없는 공용으로 사용할 변수들을 가진다.
//물론 지금은 없다.. 후에 있을 확장을 위해.
public class Operator <T extends Number> implements AbstractOperation<T>{

    //쓰지도 않지만.. 인터페이스 오버라이드 안하면 안되니까...
    @Override
    public T operate(Class<T> type,T firstNumber, T secondNumber) {
        return null;
    }
}
