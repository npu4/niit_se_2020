import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numberOne = null;
        Integer numberTwo = null;
        String restriction = String.format("Допустимы числа из диапазона [%s - %s]", MIN_VALUE, MAX_VALUE);

        while (numberOne == null || numberTwo == null) {
            try {
                System.out.printf("Введите первое число. %s:\n", restriction);
                numberOne = Integer.parseInt(scanner.next());

                System.out.printf("Введите второе число. %s: \n", restriction);
                numberTwo = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Упс! Кажется вы ввели какую-то абракадабру или слишком длинное число. Давай-те повторим ...");
            }
        }

        if (numberOne > numberTwo) {
            System.out.printf("Число %s больше %s\n", numberOne, numberTwo);
        } else {
            System.out.printf("Число %s меньше %s\n", numberTwo, numberOne);
        }

        int sum = numberOne + numberTwo;

        System.out.println("Сумма чисел: " + sum);
    }
}