import java.util.Random;

public class BreakAndContinue {


    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                continue;
            }

           // System.out.println(i + " нечетное");

        }


        Random r = new Random();



        mark:
        while (true) {

            final int firstDigit = r.nextInt(10);


            while (true) {
                final int secondDigit = r.nextInt(10);

                if ("13".equals(firstDigit + "" + secondDigit )) {
                    System.out.println("Нашёл 13, цикл завершается");
                    break mark;
                } else {
                    System.out.println("Первое число не 1, создаем его заново во внешнем цикле");
                    continue mark;
                }


            }
        }


    }
}
