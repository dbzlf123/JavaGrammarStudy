package calculator;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    public static boolean start() throws Exception{
        Scanner sc = new Scanner(System.in);

        Calculator arithmeticCalculator = new ArithmeticCalculator(new LinkedList<>());
        Calculator circleCalculator = new CircleCalculator(new LinkedList<>());

        while(true)  {

            String firstNumber, secondNumber;
            double result;
            String symbols;
            String etcStr;
            String radius;

            System.out.println("사칙연산 진행 : 1, 원의 너비 구하기 : 2  를 선택하세요 ");
            etcStr = sc.nextLine();

            switch (etcStr){
                case "1" :
                    System.out.println("첫 번째 숫자를 입력하세요: ");
                    firstNumber = sc.nextLine();
                    arithmeticCalculator.checkNum(firstNumber);
                    arithmeticCalculator.setFirstNumber(firstNumber);

                    System.out.println("두 번째 숫자를 입력하세요: ");
                    secondNumber = sc.nextLine();
                    arithmeticCalculator.checkNum(secondNumber);
                    arithmeticCalculator.setSecondNumber(secondNumber);

                    System.out.println("사칙연산 기호를 입력하세요: ");
                    symbols = sc.nextLine();
                    arithmeticCalculator.checkOperator(symbols);

                    result = arithmeticCalculator.calculate();
                    System.out.println("결과: " + result);
                    arithmeticCalculator.addResult(result);

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    etcStr = sc.nextLine();
                    if(etcStr.equals("remove")) arithmeticCalculator.removeResult();

                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    etcStr = sc.nextLine();
                    if(etcStr.equals("inquiry"))arithmeticCalculator.inquiryResults();

                    break;

                case "2" :
                    System.out.println("값을 구한 원의 반지름을 입력하세요 : ");
                    radius = sc.nextLine();

                    circleCalculator.checkNum(radius);
                    circleCalculator.setRadius(radius);
                    result = circleCalculator.calculate();

                    System.out.println("원의 넓이 입니다. : " + result);

                    circleCalculator.addResult(result);

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                    etcStr = sc.nextLine();
                    if(etcStr.equals("remove")) circleCalculator.removeResult();

                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                    etcStr = sc.nextLine();
                    if(etcStr.equals("inquiry"))circleCalculator.inquiryResults();
                    break;
            }


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            etcStr = sc.nextLine();
            if(etcStr.equals("exit")) break;
        }

        return true;
    }

    public static void main(String[] args) {

        boolean temp = false;
        while(!temp){
            try {
                    temp = start();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
