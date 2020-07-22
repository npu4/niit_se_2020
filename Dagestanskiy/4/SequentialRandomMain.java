public class SequentialRandomMain {
    public static void main(String[] args) {
        SequentialRandom r1 = new SequentialRandom();
        SequentialRandom r2 = new SequentialRandom();
        SequentialRandom r3 = new SequentialRandom();
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
        r1.resetRandom();
        System.out.println("Следующее число будет случайным.");
        SequentialRandom r4 = new SequentialRandom();
        SequentialRandom r5 = new SequentialRandom();
        SequentialRandom r6 = new SequentialRandom();
        System.out.println(r4.getI());
        System.out.println(r5.getI());
        System.out.println(r6.getI());


    }
}
