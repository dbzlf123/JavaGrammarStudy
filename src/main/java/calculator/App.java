package calculator;

import exception.CalculatorException;
import formula.FormulaHelper;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //타입 바꾸고 싶으면 요기 ... 제네릭 클래스라 생성시 초기화가 맞다. 완전 동적으로 하라면 제네릭 클래스를 빼고 해보자
        ArithmeticCalculator<Integer> arithmeticCalculator = new ArithmeticCalculator<>();
        arithmeticCalculator.setType(Integer.class);
        CircleCalculator circleCalculator = new CircleCalculator();

        while (true) {

            //왜 String ? 스캐너가 입력받는 타입이 너무 빡빡하다..
            String firstNumber, secondNumber, arithmeticResult;
            String radius;
            double circleResult;
            String symbols;
            String etcStr;


            System.out.println("사칙연산 진행 : 1, 원의 너비 구하기 : 2  를 선택하세요 ");
            etcStr = sc.nextLine();

                switch (etcStr) {
                    case "1":
                        try {
                        System.out.println("첫 번째 숫자를 입력하세요: ");
                        firstNumber = sc.nextLine();

                            FormulaHelper.checkNum(firstNumber);
                            arithmeticCalculator.setFirstNumber(firstNumber);



                        System.out.println("두 번째 숫자를 입력하세요: ");
                        secondNumber = sc.nextLine();

                            FormulaHelper.checkNum(secondNumber);
                            arithmeticCalculator.setSecondNumber(secondNumber);

                        System.out.println("사칙연산 기호를 입력하세요: ");
                        symbols = sc.nextLine();

                            FormulaHelper.checkOperator(symbols);
                            arithmeticCalculator.setSymbol(symbols);
                        }catch (Exception e){
                            break;
                        }

                        arithmeticResult = arithmeticCalculator.calculate().toString();
                        System.out.println("결과: " + arithmeticResult);
                        arithmeticCalculator.addResult(Double.parseDouble(arithmeticResult));

                        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                        etcStr = sc.nextLine();
                        if (etcStr.equals("remove")) arithmeticCalculator.removeResult();

                        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                        etcStr = sc.nextLine();
                        if (etcStr.equals("inquiry")) arithmeticCalculator.inquiryResults();

                        System.out.println("방금 결과보다 작은 값을 보시겠습니까? (Yes 입력 시 조회)");
                        etcStr = sc.nextLine();
                        if (etcStr.equals("Yes")) arithmeticCalculator.compareResult(arithmeticResult);

                        //클래스를 제네릭으로 설정했으므로 런타임 변경은 안된다. 나중에 내 맘대로 바꿔보기
//                        System.out.println("바꾸실 타입을 결정하세요 : ex) int, float, double, long" );
//                        etcStr = sc.nextLine();
//                        arithmeticCalculator.changeType(etcStr);


                        break;

                    case "2":
                        System.out.println("값을 구한 원의 반지름을 입력하세요 : ");
                        radius = sc.nextLine();

                        try {
                            FormulaHelper.checkNum(radius);
                            circleCalculator.setRadius(radius);
                        }catch (Exception e){
                            break;
                        }

                        circleResult = circleCalculator.calculate();

                        System.out.println("원의 넓이 입니다. : " + circleResult);

                        circleCalculator.addResult(circleResult);

                        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                        etcStr = sc.nextLine();
                        if (etcStr.equals("remove")) circleCalculator.removeResult();

                        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                        etcStr = sc.nextLine();
                        if (etcStr.equals("inquiry")) circleCalculator.inquiryResults();
                        break;
                }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            etcStr = sc.nextLine();
            if (etcStr.equals("exit"))
                break;

        }
    }
}
