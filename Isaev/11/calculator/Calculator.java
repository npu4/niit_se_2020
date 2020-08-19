package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator{

    static int numberOfOperation = 0;
    static List<String> namesOfOperations = new ArrayList<>();
    static List<Operation> operations = new ArrayList<>();

    void addOperation(String operationName,Operation implementation){
        namesOfOperations.add(operationName);
        operations.add(implementation);
        numberOfOperation++;
    }

    Double calculate(String operationName,Double numberOne,Double numberTwo){
        Operation operation = operations.get(namesOfOperations.indexOf(operationName));
        return operation.doOperation(numberOne,numberTwo);
    }

}
