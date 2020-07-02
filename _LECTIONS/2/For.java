import java.util.Arrays;

public class For {


    public static void main(String[] args) {
        int[] array = new int[5];
        int i = 0;

        for (; i < array.length; ) {
            array[i] = i*i;
            i++;
        }


        System.out.println(Arrays.toString(array));
    }
}
