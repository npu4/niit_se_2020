public class Fruit {
    int weight;

    public Fruit(int weight) {
        this.weight = weight;
    }

    public Fruit() {
        this.weight = 300;
    }

    public Fruit getRandomFruit(){
        int i = rnd(0,2);
        if (i == 0) {
            String[] c;
            for (String s : c = new String[]{"красный", "зелёный", "желтый"}) {
                
            }
            ;
            Fruit f = new Apple(rnd(100,300),c[rnd(0,2)] );
            return f;
        }
        if (i == 1){
            Fruit f = new Orange(rnd(100,300),rnd(0,20));
            return f;
        } else{
            Fruit f = new Pineapple(rnd(500,100), rnd(5,20));
            return f;
        }

    }

    @Override
    public String toString() {
        return "Фрукт " +
                "вес = " + weight +
                " гр.";
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

class Apple extends Fruit {
    String color;

    public Apple(int weight, String color) {
        super(weight);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Яблоко   " +
                "вес = " + weight +
                " гр. , цвет = " + color +
                "";
    }
}

class Orange extends Fruit {
    int skinThickness;

    public Orange(int weight, int skinThickness) {
        super(weight);
        this.skinThickness = skinThickness;
    }

    @Override
    public String toString() {
        return "Апельсин " +
                "вес = " + weight +
                " гр., толщина кожуры = " + skinThickness +
                " мм.";
    }
}

class Pineapple extends Fruit {
    int tailHeight;

    public Pineapple(int weight, int tailHeight) {
        super(weight);
        this.tailHeight = tailHeight;
    }

    @Override
    public String toString() {
        return "Ананас " +
                "  вес = " + weight +
                "гр., высота хвоста = " + tailHeight +
                " см.";
    }
}