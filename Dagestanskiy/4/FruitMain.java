public class FruitMain {
    public static void main(String[] args) {
        Fruit f = new Fruit();
        Fruit[] fm = new Fruit[4];
        for (int i = 0; i < 4 ; i++) {
            fm[i] = f.getRandomFruit();
            System.out.println(fm[i].toString());
        }
    }
}
