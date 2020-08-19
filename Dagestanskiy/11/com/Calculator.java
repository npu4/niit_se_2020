package com;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String,Operation> operationMap = new HashMap<>();
    void calculate(String operatorName,Double number1,Double number2) {
        System.out.println( operatorName+": (" +number1+","+number2+") = "
                +operationMap.get(operatorName).doOperation(number1, number2));
    }
    void addOperation(String operationName, Operation implementation){
        operationMap.put(operationName, implementation);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addOperation("multiplication", (a,b)->a*b);
        calculator.addOperation("division",(a,b)-> a/b);
        calculator.addOperation("sum", (a,b)->a+b);
        calculator.addOperation("subtraction", (a,b)->a-b);
        calculator.addOperation("exponentiation",(a,b)->Math.pow(a, b));
        calculator.addOperation("root",(a,b)->Math.pow(a, 1/b));

        calculator.calculate("multiplication", 3d, 5d);
        calculator.calculate("division", 36d, 6d);
        calculator.calculate("sum", 2d, 2d);
        calculator.calculate("subtraction", 5d, 3d);
        calculator.calculate("exponentiation", 5d, 3d);
        calculator.calculate("root", 125d,3d);


    }
}

