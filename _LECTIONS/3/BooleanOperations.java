public class BooleanOperations {


    public static void main(String[] args) {
        boolean tr = true;
        boolean fl = false;

/*
        System.out.println(tr && fl && false && false && false);
        System.out.println(tr || fl);*/


        System.out.println(getTrue() || getFalse());


        System.out.println(tr ^ fl);
        System.out.println(true ^ true);


        System.out.println(!tr);
        System.out.println(tr);


        String str = "Hello";
        final String concat = str.concat(", World!");
        System.out.println(str);
        System.out.println(concat);


      //  if (54 % 10) {
    }


    static boolean getTrue() {
        System.out.println("Возвращаю true");
        return true;
    }

    static boolean getFalse() {
        System.out.println("Возвращаю false");
        return false;
    }
}
