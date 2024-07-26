package formula;

import exception.CalculatorException;

import java.util.regex.Pattern;

public class FormulaHelper {

    //String 가져다 쓰는건 타입 아무거나 받아다 쓰려고.. 스캐너가 너무 한정적이다..
    //내부에서 쓸것이고 바뀔일도 없으니 static final...
    private static final String symbolRegularExpression = "[+\\-*/%]";
    private static final String numRegularExpression = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?$";

    //들어온 인풋과 정규식을 비교하여 옳바른 값인지 확인
    //왜 static? 객체 인스턴스 안시키고 그냥 뽑아다 쓰려고.
    public static void checkNum(String input) throws CalculatorException {
        if (!Pattern.matches(numRegularExpression, input)) {
            throw new CalculatorException("값");
        }
    }

    public static void checkOperator(String operationInput) throws CalculatorException {
        if (!Pattern.matches(symbolRegularExpression, operationInput)) {
            throw new CalculatorException("연산자");
        }
    }

    //오버로딩, 여러가지 타입 그냥 받아서 처리해보려고 만들어둠, 현재는 계산기가 제네릭 클래스여서 런타임 변경이 어렵다.
    //즉 만약 Arithmetic 클래스를 Integer 로 설정해놨으면 계속 Integer 만 들어오겠지..
    public static <T extends Number> T doTypeChange(Class<T> input, String number) {
        if (input == Integer.class) {
            //String 으로 받아온 값이 2.5 같은 float, double 면 변환안되므로 예외처리~
            try {
                return input.cast(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                return input.cast((int) Double.parseDouble(number));
            }
        } else if (input == Double.class)
            return input.cast(Double.parseDouble(number));
        else if (input == Float.class)
            return input.cast(Float.parseFloat(number));
        else if (input == Long.class)
            return input.cast(Long.parseLong(number));
        else
            throw new ClassCastException("잘못된 숫자"); // T 타입으로 캐스팅하면서 보내주니까 일단 에러는 ClassCastException 으로...

    }

    //모든 숫자 클래스는 Number 의 자식이다. 그러므로 T 도 Number 형으로 제한.
    //요녀석이 처음 설정 클래스에 따라 값을 변환시켜서 보내줌.
    public static <T extends Number> T doTypeChange(Class<T> input, Number number) {
        if (input == Integer.class)
            return input.cast(number.intValue());
        else if (input == Double.class)
            return input.cast(number.doubleValue());
        else if (input == Float.class)
            return input.cast(number.floatValue());
        else if (input == Long.class)
            return input.cast(number.longValue());

        throw new ClassCastException("잘못된 숫자");
    }
}
