public class JavaLinks {


    public static void main(String[] args) {
        TV oneTv = new TV();

        TV anotherReferrence = oneTv;
        anotherReferrence.location = " Ванная";

        System.out.println(oneTv.geLocation());


    }
}
