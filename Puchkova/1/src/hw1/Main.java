package hw1;

public class Main {
    public static void main(String[] args) {
        Integer a = Integer.parseInt(args[0]);
        Integer b = Integer.parseInt(args[1]);

        if (a > b) {
            System.out.printf("Число %s больше %s", a, b);
        }
        else {
            System.out.printf("Число %s меньше %s", a, b);
        }
    }
}