public class NumberFormats {


    public static void main(String[] args) {
        int a = 42;
        Integer b = 0xFF;
        Integer c = 0b1101;
        Integer d = 077;



         Long aL = 42L;
        Long bL = 0xFFL;
        Long cL = 0b1101L;
        Long dL = 077L;


        Double dbl = 42.0;
        Double dbl2 = 42.;
        Double dbl3 = .2;

        Float f = 42.0f;



        Double scienceNotation = 25E2;

        System.out.println(scienceNotation);
/*
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);


        System.out.println(aL);
        System.out.println(bL);
        System.out.println(cL);
        System.out.println(dL);

        System.out.println(aL);
        System.out.println(bL);
        System.out.println(cL);
        System.out.println(dL);

        System.out.println(dbl);
        System.out.println(dbl2);
        System.out.println(dbl3);*/


        String str = "Some \r\n string";
        System.out.println(str);

        char cha = 'b';
        System.out.println(cha);

        char[] chars = {'s', 'o', 'm', 'e', ' ', 's', 't', 'r'};
        final String s = new String(chars);
        System.out.println(s);

    }
}
