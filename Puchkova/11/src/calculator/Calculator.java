package calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String, Operation> operations = new HashMap<>();

    double calculate(String operationName, Double number1, Double number2) {
        return operations.get(operationName).doOperation(number1, number2);
    }

    void addOperation(String operationName, Operation implementation) {
        operations.put(operationName, implementation);
    }
}
