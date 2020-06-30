import java.util.Scanner;

class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numberOne = null;
        Integer numberTwo = null;

        while (numberOne == null || numberTwo == null) {
            try {
                System.out.println("Введите первое число: ");
                numberOne = Integer.parseInt(scanner.next());

                System.out.println("Введите второе число: ");
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