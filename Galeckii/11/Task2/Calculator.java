package Task2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    Map<String, Operation> operations = new HashMap<>();

    public void calculate(String operationName, Double number1, Double number2) {
        System.out.println(operations.get(operationName).doOperation(number1, number2));
    }

    public void addOperation(String operationName, Operation implementation) {
        operations.put(operationName, implementation);
    }
}
