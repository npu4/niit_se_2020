public class SytemVariables {


    public static void main(String[] args) {
     /*   for (String arg : args) {
            System.out.println(arg);
        }
*/

       // System.out.println(System.getProperty("someVariable"));


        final Integer integer = Integer.getInteger("someVariable");
        System.out.println(integer + 1);


        final int i = Integer.parseInt("42");
        System.out.println(i);
    }
}
