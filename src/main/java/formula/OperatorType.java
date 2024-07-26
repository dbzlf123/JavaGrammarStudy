package formula;

public enum OperatorType {
    ADD("+"), DIVIDE("/"), MOD("%"), MULTIPLY("*"), SUBTRACT("-");

    private final String operator;

    //생성하면서 초기화 박아주기.
    OperatorType(String operator){
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

}
