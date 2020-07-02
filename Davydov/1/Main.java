
public class Main {

    public static void main(String[] args) {
        int ValueOne = 42;
        int ValueTwo = 43;
        int sum=0;
        if (ValueOne > ValueTwo) {
            System.out.println("Число " + ValueOne + " Больше числа " + ValueTwo);
        } else {
            System.out.println("Число " + ValueTwo + " Больше числа " + ValueOne);
        }
        sum=ValueOne+ValueTwo;
        System.out.println("Cумма: "+sum);
    }
}
