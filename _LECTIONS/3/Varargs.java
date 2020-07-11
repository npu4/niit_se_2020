public class Varargs {


    public static void main(String[] args) {
        System.out.println(sum("Сумма четырх чисел",new int[] {6,2, 4,7}));
        System.out.println(sum("Сумма четырх чисел",6,2, 4,7));
    }



    static int sum(String intro,int ... a) {


        System.out.println(intro);
        int result = 0;

        for (int i : a) {
            result += i;
        }

        return result;
    }
}
