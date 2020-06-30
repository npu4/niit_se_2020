import java.util.Scanner;

class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numberOne;
        Integer numberTwo;

        System.out.println("Введите первое число: ");
        numberOne = scanner.nextInt();

        System.out.println("Введите второе число: ");
        numberTwo = scanner.nextInt();

        if (numberOne > numberTwo) {
            System.out.printf("Число %s больше %s\n", numberOne, numberTwo);
        } else {
            System.out.printf("Число %s меньше %s\n", numberTwo, numberOne);
        }

        int sum = numberOne + numberTwo;

        System.out.println("Сумма чисел: " + sum);
    }
}