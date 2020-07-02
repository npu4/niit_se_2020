public class IfExample {


    public static void main(String[] args) {
        int a = 42;
        int b;



        if (a == 1) {
            System.out.println("Что-то не так");
        }

/*      так не работает
        if (a = 1) {
            System.out.println("Что-то не так");
        }*/


        boolean bolleanValue = false;


        boolean anotherBoolean = !bolleanValue;
        if (bolleanValue) {
            System.out.println("Что-то не так");
        }
        
        if (anotherBoolean) {
            System.out.println("Всё правильно");
        }


    }
}
