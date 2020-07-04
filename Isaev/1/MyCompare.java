import java.util.Scanner;

public class MyCompare {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please,enter first number: ");
        int firstNumber = myScanner.nextInt();
        System.out.println("Please,enter second number: ");
        int secondNumber = myScanner.nextInt();

        if (firstNumber == secondNumber) {
            System.out.println("Your number's are equal");
        } else if (firstNumber > secondNumber) {
            System.out.println("First number " + firstNumber + " is bigger");
        } else {
            System.out.println("Second number " + secondNumber + " is bigger");
        }

        System.out.println("Sum of first and second number equal: " + (firstNumber + secondNumber));

    }

}
