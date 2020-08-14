package org.mironyuk.calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addOperation("Умножение", (a, b) -> a * b);
        calculator.addOperation("Деление", (a, b) -> a / b);
        calculator.addOperation("Сложение", Double::sum);
        calculator.addOperation("Вычитание", (a, b) -> a - b);
        calculator.addOperation("Возведение в степень", Math::pow);
        calculator.addOperation("Извлечение корня степени N", Main::nthRoot);

        System.out.println(calculator.calculate("Умножение", 7, 5));
        System.out.println(calculator.calculate("Вычитание", 12, 2));
        System.out.println(calculator.calculate("Возведение в степень", 2, 3));
        System.out.println(calculator.calculate("Извлечение корня степени N", 8, 3));
    }

    public static double nthRoot(double x, double n) {
        if (x < 0 && n % 2 == 1) {
            return -Math.pow(-x, 1 / n);
        }

        return Math.pow(x, 1 / n);
    }
}
