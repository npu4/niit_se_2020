public class PropertyExample {


    public static void main(String[] args) {
        final Integer integer = Integer.getInteger("aSomeInteger");
        System.out.println(integer);

        final String aSomeInteger = System.getProperty("aSomeInteger");
        System.out.println("From getPoperty" + aSomeInteger);


        final String osName = System.getProperty("os.name");
        System.out.println("osName" + osName);
    }
}
