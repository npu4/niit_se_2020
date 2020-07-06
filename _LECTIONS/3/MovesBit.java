public class MovesBit {


    public static void main(String[] args) {
        byte one = 1;
        // 0 0 0 0 0 0 0 1 =>         // 0 0 0 0 1 0 0 0
        // 0 0 0 0 0 0 1 1 =>         // 0 0 0 0 1 1 0 0

        byte two = 2;

        // 0 0 0 0 0 0 1 0

        byte three = 3;

        // 0 0 0 0 0 0 1 1

        byte five = 5;
        // 0 0 0 0 0 1 0 1


        System.out.println(three & one);
        System.out.println(three | one);
        System.out.println(three | five);

    }
}
