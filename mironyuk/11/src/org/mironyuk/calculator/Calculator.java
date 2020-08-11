package org.mironyuk.calculator;

import java.util.HashMap;
import java.util.Map;

final public class Calculator {
    private Map<String, Operation> operations = new HashMap<>();

    double calculate(String operationName, double number1, double number2) {
        return operations.get(operationName).doOperation(number1, number2);
    }

    void addOperation(String operationName, Operation operation) {
        operations.put(operationName, operation);
    }
}
