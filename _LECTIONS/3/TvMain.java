public class TvMain {


    public static void main(String[] args) {
        TV tv = new TV("1st channel",100,"Гостинная");
        TV anotherTv = new TV("2nd channel",0,"Кухня");

        System.out.println(tv.geLocation());
        System.out.println(anotherTv.geLocation());



        anotherTv.printInfo();
        tv.printInfo();


        TV empty = new TV();
        empty.printInfo();
    }
}
