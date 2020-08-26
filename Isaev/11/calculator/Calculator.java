package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator{

    static int numberOfOperation = 0;
    static Map<String,Operation> operationMap = new HashMap<>();

    void addOperation(String operationName,Operation implementation){
        operationMap.put(operationName,implementation);
        numberOfOperation++;
    }

    Double calculate(String operationName,Double numberOne,Double numberTwo){
        Operation operation = operationMap.get(operationName);
        return operation.doOperation(numberOne,numberTwo);
    }

}
