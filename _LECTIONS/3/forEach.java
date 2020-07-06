public class forEach {

    public static void main(String[] args) {

        String[] names = {"Vasya", "Petya", "Kolya"};


      /*  for (int i = 0; i < names.length; i++) {
            String name = names[i];
            System.out.println("Имя №" + i + name);


        }*/


        for (String name : names) {
            System.out.println(name);
        }


        System.out.println((double) 5 / 2);

    }
}
