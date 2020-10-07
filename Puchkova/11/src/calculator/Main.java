package calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addOperation("sum", (a, b) -> a+b);
        System.out.println("2 + 3 \t= \t" + calculator.calculate("sum", 2d, 3d));

        calculator.addOperation("subtract", (a, b) -> a-b);
        System.out.println("2 - 3 \t= \t" + calculator.calculate("subtract", 2d, 3d));

        calculator.addOperation("multiply", (a, b) -> a*b);
        System.out.println("2 * 3 \t= \t" + calculator.calculate("multiply", 2d, 3d));

        calculator.addOperation("divide", (a, b) -> a/b);
        System.out.println("68 : 13\t= \t" + calculator.calculate("divide", 68d, 13d));

        calculator.addOperation("power", (a, b) -> Math.pow(a,b));
        System.out.println("2 ^ 3 \t= \t" + calculator.calculate("power", 2d, 3d));

        calculator.addOperation("rootn", (a, b) -> Math.pow(a,calculator.calculate("divide", 1d, b)));
        System.out.println("sqrt(8,3) \t= \t" + calculator.calculate("rootn", 8d, 3d));
    }
}
