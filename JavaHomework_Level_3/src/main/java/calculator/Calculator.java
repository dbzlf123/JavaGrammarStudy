package calculator;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Calculator {

    private final Queue<Double> resultQueue; //Final 설정 이유 : 한번 설정하면 다시 안바뀔테니까.

    public Calculator(Queue<Double> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public void removeResult() {
        if(!resultQueue.isEmpty()){
            resultQueue.remove();
        }
    }

    public Queue<Double> getResultQueue() {
        return resultQueue;
    }

    public void addResult(double result){
        resultQueue.add(result);
    }

    public void inquiryResults(){
        resultQueue.forEach(System.out::println);
    }
}
