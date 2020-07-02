public class Arrays {


    public static void main(String[] args) {
        String[] names = new String[4];
        names[0] = "Андрей";
        names[1] = "Vasya";
        names[2] = "Petya";
        names[3] = "Masha";


        System.out.println(java.util.Arrays.toString(names));


        String[] names2;
        names2 = new String[]{
                "Андрей",
                "Vasya",
                "Petya",
                "Masha",
        };

        System.out.println(java.util.Arrays.toString(names2));

        String[] names3 =  {
                "Андрей",
                "Vasya",
                "Petya",
                "Masha",
        };

        System.out.println(java.util.Arrays.toString(names3));


        System.out.println(names[2]);
       // System.out.println(names[4]); не работает
    }
}
