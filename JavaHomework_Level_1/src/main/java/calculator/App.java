package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNumber, secondNumber;
        int result = 0;
        String symbols;
        Queue<Integer> resultQueue = new LinkedList<>();
        String etcStr = "";

        while(true) {
            System.out.println("첫 번째 숫자를 입력하세요: ");
            firstNumber = sc.nextInt();

            System.out.println("두 번째 숫자를 입력하세요: ");
            secondNumber = sc.nextInt();

            sc.nextLine();

            System.out.println("사칙연산 기호를 입력하세요: ");
            symbols = sc.nextLine();

            System.out.println(firstNumber);
            System.out.println(secondNumber);
            System.out.println(symbols);

            switch (symbols) {
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "/":
                    if (secondNumber == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                    result = firstNumber / secondNumber;
                    break;
            }

            System.out.println("결과: " + result);
            resultQueue.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            etcStr = sc.nextLine();
            if(etcStr.equals("remove"))resultQueue.remove();

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            etcStr = sc.nextLine();
            if(etcStr.equals("inquiry")){
                resultQueue.forEach(System.out::println);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
             etcStr = sc.nextLine();
            if(etcStr.equals("exit")) break;
        }

    }
}
