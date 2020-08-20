package Task2;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addOperation("addition", Double::sum);
        calculator.addOperation("subtraction", (number1, number2) -> number1 - number2);
        calculator.addOperation("multiplication", (number1, number2) -> number1 * number2);
        calculator.addOperation("division", (number1, number2) -> number1 / number2);
        calculator.addOperation("exponentiation", Math::pow);
        calculator.addOperation("root extraction", (number1, number2) -> Math.pow(number1, 1 / number2));

        calculator.calculate("exponentiation", 2.0, 8.0);
        calculator.calculate("root extraction", 256.0, 8.0);
    }
}
