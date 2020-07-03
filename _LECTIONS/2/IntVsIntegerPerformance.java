public class IntVsIntegerPerformance {


    public static void main(String[] args) {

        final long currentTime = System.currentTimeMillis();

        int[] prim = new int[10_000_000];
        for (int i : prim) {
            prim[i] = i +1;
        }

        System.out.println("primitive time:" + (System.currentTimeMillis() - currentTime));

        final long currentTimeObject = System.currentTimeMillis();

        Integer[] objects = new Integer[10_000_000];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = i + 1;
        }



        Integer integer = 5;

        System.out.println("Object time:" + (System.currentTimeMillis() - currentTimeObject));


    }
}
